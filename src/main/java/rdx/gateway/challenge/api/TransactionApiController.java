package rdx.gateway.challenge.api;

import rdx.gateway.challenge.coremodel.CommittedTransactionsRequest;
import rdx.gateway.challenge.coremodel.CommittedTransactionsResponse;
import rdx.gateway.challenge.coremodel.NetworkIdentifier;
import rdx.gateway.challenge.coremodel.PartialStateIdentifier;
import rdx.gateway.challenge.model.TokensTransferedResult;
import rdx.gateway.challenge.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Generated;
import javax.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@RestController
@RequestMapping("${openapi.codechallenge.base-path:/v1}")
@Slf4j
public class TransactionApiController implements TransactionApi {

    @Autowired
    TransactionService transactionService;

    /**
     * GET /transfers : List tokens and amount transferred
     *
     * @param input (optional)
     * @return Operation success (status code 200)
     * or Wrong Parameters (status code 400)
     * or Server error (status code 500)
     */
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/transactions",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @Override
    public Mono<CommittedTransactionsResponse> transfersGet(
            @Valid @RequestBody(required = false) CommittedTransactionsRequest input
    ) {


        return transactionService.transactionsPost(input)
                .doOnRequest(s -> {
                    log.info("Start elaborating incoming request");
                    log.debug("Start elaborating incoming request with payload", input);
                })
                .map( committedTransactionsResponse ->  {
                    log.trace("Result payload", committedTransactionsResponse);
                    return committedTransactionsResponse;
                })
                .doOnSuccess( committedTransactionsResponse -> {
                    log.info("end elaborating request");
                    log.debug("end elaborating request witn response payload",committedTransactionsResponse);
                });
    }


}
