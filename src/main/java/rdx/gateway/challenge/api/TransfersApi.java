/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.1.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package rdx.gateway.challenge.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ServerWebExchange;
import rdx.gateway.challenge.model.TokensTransferedResult;
import reactor.core.publisher.Mono;

import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
public interface TransfersApi {

    /**
     * GET /transfers : Returns transfers of tokens
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
    default ResponseEntity<TokensTransferedResult> transfersGet() {
        return null;
    }


    /**
     * GET /transfers/{id} : Returns transfers of tokens with ID rri_id
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
    default ResponseEntity<TokensTransferedResult> transfersIdGet(
         @PathVariable("id") String id
    ) {
        return null;
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
    default ResponseEntity<TokensTransferedResult> transfersAddress() {
        return null;
    }

}
