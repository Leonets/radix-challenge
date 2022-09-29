package rdx.gateway.challenge.service;

import rdx.gateway.challenge.coremodel.CommittedTransactionsRequest;
import rdx.gateway.challenge.coremodel.CommittedTransactionsResponse;
import rdx.gateway.challenge.coreclient.service.TransactionApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionApiClient transactionApiClient;

     @Override
    @NewSpan("coreapi-service")
    public Mono<CommittedTransactionsResponse> transactionsPost(CommittedTransactionsRequest request) {

        return transactionApiClient.transactionsPost(request)
                .doOnRequest(q -> {
                    log.info("Start elaborating incoming request");
                    log.debug("Start elaborating incoming request with payload", request);
                })
                .map(q -> {
                    return q;
                })
                .doOnNext(q -> {
                    log.info("end elaborating request");
                    log.debug("end elaborating request witn response payload", q);
                })
                .onErrorResume(err -> {
                    log.error("handleRestApiClientException", err);
                    return Mono.error(err);
                });
    }
}
