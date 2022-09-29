package rdx.gateway.challenge.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rdx.gateway.challenge.model.AddressesRequest;
import rdx.gateway.challenge.model.OperationResult;
import rdx.gateway.challenge.util.AddressStorage;
import reactor.core.publisher.Mono;

import javax.annotation.Generated;
import javax.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Controller
@RequestMapping("${openapi.radixChallenge.base-path:/v1}")
public class MonitorApiController implements MonitorApi {

    @Autowired
    AddressStorage addressStorage;

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
    @Override
    public ResponseEntity<OperationResult> monitorDelete(
    ) {
        addressStorage.removeAllFromList();
        OperationResult result = new OperationResult();
        result.setResult("Addresses List removed from monitoring");
        return ResponseEntity.ok(result);
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
    @Override
    public ResponseEntity<OperationResult> monitorPost(
            @Valid @RequestBody(required = false) AddressesRequest addressesRequest
    ) {
        addressStorage.addToList(addressesRequest.getAddress());
        OperationResult result = new OperationResult();
        result.setResult("Addresses List added to monitoring");
        return ResponseEntity.ok(result);
    }



}
