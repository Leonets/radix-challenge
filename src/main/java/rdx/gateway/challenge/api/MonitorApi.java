/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.1.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package rdx.gateway.challenge.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rdx.gateway.challenge.model.AddressesRequest;
import rdx.gateway.challenge.model.OperationResult;
import reactor.core.publisher.Mono;

import javax.annotation.Generated;
import javax.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
public interface MonitorApi {

    /**
     * DELETE /monitor : Remove a list of addresses from the monitoring
     * Addresses to be monitored anymore
     *
     * @return Operation success (status code 200)
     *         or Wrong Parameters (status code 400)
     *         or Server error (status code 500)
     */
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/monitor",
        produces = { "application/json" }
    )
    default ResponseEntity<OperationResult> monitorDelete(
    ) {
        return null;
    }


    /**
     * POST /monitor : Adds a list of addresses to be monitored
     * Adds addresses to be monitored
     *
     * @param addressesRequest  (optional)
     * @return Operation success (status code 200)
     *         or Wrong Parameters (status code 400)
     *         or Server error (status code 500)
     */
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/monitor",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<OperationResult> monitorPost(
         @Valid @RequestBody(required = false) AddressesRequest addressesRequest
    ) {
        return null;
    }

}
