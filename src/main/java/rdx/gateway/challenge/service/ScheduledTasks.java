package rdx.gateway.challenge.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import rdx.gateway.challenge.coremodel.*;
import rdx.gateway.challenge.model.Transfers;
import rdx.gateway.challenge.util.ConverterStringToBigDecimal;
import rdx.gateway.challenge.util.Printer;
import rdx.gateway.challenge.util.TransfersStorage;

import javax.validation.Valid;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    TransactionService transactionService;

    @Autowired
    ConverterStringToBigDecimal converterStringToBigDecimal;

    @Autowired
    Printer printer;

    @Autowired
    TransfersStorage storage;

    long state_version = 0L;

    @Scheduled(initialDelay = 10000, fixedRate = 5000)
    public void request_new_transactions() {

        log.info(" Ready to request transactions now {} for state_version {}", dateFormat.format(new Date()) , state_version);

        NetworkIdentifier networkIdentifier = new NetworkIdentifier().network("stokenet");
        PartialStateIdentifier stateIdentifier = new PartialStateIdentifier().stateVersion(state_version);
        stateIdentifier.setTransactionAccumulator(null);
        CommittedTransactionsRequest committedTransactionsRequest = new CommittedTransactionsRequest()
                .networkIdentifier(networkIdentifier)
                .limit(100L)
                .stateIdentifier(stateIdentifier);

        state_version = state_version + 100L;

        log.info(" requesting transactions to core api \n" + printer.prettyPrintMe(committedTransactionsRequest) );

        //loop around this
        transfersGet(committedTransactionsRequest);
    }

    public void transfersGet(
            @Valid @RequestBody(required = false) CommittedTransactionsRequest committedTransactionsRequest
    ) {
        transactionService.transactionsPost(committedTransactionsRequest)
                .doOnRequest(s -> {
                    log.debug("Start elaborating incoming request with payload", committedTransactionsRequest);
                })
                .map( response ->  {
                    return response;
                })
                .doOnSuccess(
                            response -> extractData(response)
                ).block();
    }

    /**
     * public method to get unit test on it
     * @param response
     */
    public void extractData(CommittedTransactionsResponse response) {
        // Extract operation groups
        Stream<OperationGroup> operationGroups = response.getTransactions().stream()
                .flatMap(txn -> txn.getOperationGroups().stream());
        // Extract transfers
        List<Transfers> transfers = operationGroupsToTransfer(operationGroups);
        log.info(" Extracting transfers data from response, found n. {} ", transfers.size()  );
        for (Transfers transfer: transfers
             ) {
            log.info(" transfer: resource {}, amount {} ",transfer.getAddress(),transfer.getAmount());
        }

        //add the transfers found in an in-memory container
        storage.addToList(transfers);
    }

    private List<Transfers> operationGroupsToTransfer(Stream<OperationGroup> operationGroups) {
        //here I filter for any transaction ok type Token
        //and then mapping to Transfers witn only some fields (amount, address and rri)
        //last, I collect into a list
        return operationGroups
                .flatMap(group -> group.getOperations().stream())
                .filter(this::isToken)
                .map(operation -> new Transfers(operation.getEntityIdentifier().getAddress(),
                        converterStringToBigDecimal.convertTo(operation.getAmount().getValue()),
                        ((TokenResourceIdentifier)operation.getAmount().getResourceIdentifier()).getRri()))
                .collect(Collectors.toList());
    }

    /**
     * Returns a map with Address and Amount transferred
     * @param operationGroups
     * @return
     */
    Map<EntityIdentifier, BigInteger> operationGroupsToTransfers(Stream<OperationGroup> operationGroups) {
        return operationGroups
                .flatMap(group -> group.getOperations().stream())
                .filter(this::isToken)
                .collect(Collectors.toMap(
                        Operation::getEntityIdentifier,
                        op -> new BigInteger(op.getAmount().getValue())
                ));
    }


    /**
     * Returns true if the operation contains an XRD balance change, otherwise returns false
     */
    boolean isXrd(Operation operation) {
        ResourceIdentifier identifier = getResourceIdentifier(operation);
        if (identifier == null) return false;
        TokenResourceIdentifier tokenResourceIdentifier = (TokenResourceIdentifier) identifier;
        return tokenResourceIdentifier.getRri().equals("xrd_tr1qyf0x76s");
    }
//    xrd_tr1qyf0x76s - radix token on stokenet
//    xrd_rr1qy5wfsfh - radix token on mainnet

    /**
     * Returns true if the operation contains a transaction of a token (not data), otherwise returns false
     */
    boolean isToken(Operation operation) {
        ResourceIdentifier identifier = getResourceIdentifier(operation);
        if (identifier == null) return false; else return true;
    }

    /**
     * Returns true if the operation contains a transaction with XRD token, otherwise returns false
     */
    boolean isSpecificToken(Operation operation, String rrid) {
        ResourceIdentifier identifier = getResourceIdentifier(operation);
        if (identifier == null) return false;
        TokenResourceIdentifier tokenResourceIdentifier = (TokenResourceIdentifier) identifier;
        return tokenResourceIdentifier.getRri().equals(rrid);
    }

    /**
     * returns null if it is not a transaction about a Resource (perhaps it is about Data)
     * @param operation
     * @return
     */
    private ResourceIdentifier getResourceIdentifier(Operation operation) {
        if (operation.getAmount() == null) {
            return null;
        }
        ResourceIdentifier identifier = operation.getAmount().getResourceIdentifier();
        if (!(identifier instanceof TokenResourceIdentifier)) {
            return null;
        }
        return identifier;
    }


    /**
     * Simple method for logging trasaction list response
     * @param response
     */
    private void log_transactions(CommittedTransactionsResponse response) {

        List<CommittedTransaction> lista_tx = response.getTransactions();
        for (CommittedTransaction tx: lista_tx) {
            log.info(" state version " + tx.getCommittedStateIdentifier().getStateVersion());
            log.info(" transaction hash " + tx.getTransactionIdentifier().getHash());
            CommittedTransactionMetadata metadata = tx.getMetadata();
            List<OperationGroup> groups = tx.getOperationGroups();
            for (OperationGroup g: groups) {
                if (g.getMetadata()!=null) {
                    log.info(" group metadata " + (g.getMetadata()!=null ? g.getMetadata() : "No metadata"));
                }
                List<Operation> operations = g.getOperations();
                for (Operation operation: operations
                ) {
                    //log something if it is not data
                    if (!"Data".equals(operation.getType())) {
                        log.info(" amount/type " + (operation.getAmount()!=null ? operation.getAmount().getValue() : "no amount") + "/" + operation.getType());
                        if (getResourceIdentifier(operation) != null)
                            log.info(" rri " + ((TokenResourceIdentifier) getResourceIdentifier(operation)).getRri());
                        log.info(" address " + operation.getEntityIdentifier().getAddress());
                    }
                }
            }
        }

    }
}

