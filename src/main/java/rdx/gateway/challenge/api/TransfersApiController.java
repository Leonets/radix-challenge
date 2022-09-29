package rdx.gateway.challenge.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rdx.gateway.challenge.model.TokenTransfer;
import rdx.gateway.challenge.model.TokensTransferedResult;
import rdx.gateway.challenge.util.AddressStorage;
import rdx.gateway.challenge.util.TransfersStorage;
import rdx.gateway.challenge.util.mapper.TransfersMapper;
import reactor.core.publisher.Mono;

import javax.annotation.Generated;
import java.util.List;
import java.util.stream.Collectors;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Controller
@RequestMapping("${openapi.radixChallenge.base-path:/v1}")
public class TransfersApiController implements TransfersApi {

    @Autowired
    TransfersStorage transfersStorage;

    @Autowired
    AddressStorage addressStorage;

    /**
     * GET /transfers : List tokens and amount transferred
     * List the token transferred and the total amount transferred
     *
     * @return Operation success (status code 200)
     *         or Wrong Parameters (status code 400)
     *         or Server error (status code 500)
     */
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/transfers",
            produces = { "application/json" }
    )
    @Override
    public ResponseEntity<TokensTransferedResult> transfersGet() {

        List<TokenTransfer> output = TransfersMapper.MAPPER.toTransfersList(transfersStorage.getTransfers());

        TokensTransferedResult result = new TokensTransferedResult();
        result.setTransfers(output);

        return ResponseEntity.ok(result);
    }


    /**
     * GET /transfers/{id} : Returns amounts transferred to token with ID rri_id
     * List the amounts transferred only to token with ID rri_id
     *
     * @param id  (required)
     * @return Operation success (status code 200)
     *         or Wrong Parameters (status code 400)
     *         or Server error (status code 500)
     */
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/transfers/{id}",
            produces = { "application/json" }
    )
    @Override
    public ResponseEntity<TokensTransferedResult> transfersIdGet(
            @PathVariable("id") String id
    ) {
        //filter by id
        List<TokenTransfer> output = TransfersMapper.MAPPER
                                        .toTransfersList(transfersStorage.getTransfers())
                                        .stream()
                                        .filter(transfer -> id.equals(transfer.getRri()))
                                        .collect(Collectors.toList());

        TokensTransferedResult result = new TokensTransferedResult();
        result.setTransfers(output);

        return ResponseEntity.ok(result);
    }

    /**
     * GET /transfers/{address} : Returns transfer to the address specified only
     *
     * @return Operation success (status code 200)
     *         or Wrong Parameters (status code 400)
     *         or Server error (status code 500)
     */
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/transfers/address",
            produces = { "application/json" }
    )
    @Override
    public ResponseEntity<TokensTransferedResult> transfersAddress() {

        //filter by monitored address
        List<TokenTransfer> output = TransfersMapper.MAPPER
                .toTransfersList(transfersStorage.getTransfers())
                .stream()
                .filter(transfer -> addressStorage.contains(transfer.getAddress()))
                .collect(Collectors.toList());

        TokensTransferedResult result = new TokensTransferedResult();
        result.setTransfers(output);

        return ResponseEntity.ok(result);
    }

}
