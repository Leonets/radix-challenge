package rdx.gateway.challenge.api;

import rdx.gateway.challenge.coremodel.CommittedTransactionsRequest;
import rdx.gateway.challenge.coremodel.CommittedTransactionsResponse;
import rdx.gateway.challenge.model.TokensTransferedResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Mono;

import javax.annotation.Generated;
import javax.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
public interface TransactionApi {


    /**
     * GET /transfers : List tokens and amount transferred
     * List the token transferred and the total amount transferred
     *
     * @return Operation success (status code 200)
     * or Wrong Parameters (status code 400)
     * or Server error (status code 500)
     */
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/transactions",
            produces = {"application/json"}
    )
    default Mono<CommittedTransactionsResponse> transfersGet(@Valid @RequestBody(required = false) CommittedTransactionsRequest input) {
        return null;
    }



}
