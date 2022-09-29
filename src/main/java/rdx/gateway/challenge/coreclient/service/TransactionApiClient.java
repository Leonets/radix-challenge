package rdx.gateway.challenge.coreclient.service;

import rdx.gateway.challenge.config.TransactionApiClientConfig;
import rdx.gateway.challenge.coremodel.CommittedTransactionsRequest;
import rdx.gateway.challenge.coremodel.CommittedTransactionsResponse;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "transactionApiClient", url = "${coreapi.api.url}", configuration = TransactionApiClientConfig.class)
public interface TransactionApiClient {

    //Api Client vs Core api /transaction
    @PostMapping(value = "/transactions", produces = "application/json", consumes = "application/json" )
    @NewSpan("transactions-FeignClient")
    Mono<CommittedTransactionsResponse> transactionsPost(@RequestBody CommittedTransactionsRequest committedTransactionsRequest);

}