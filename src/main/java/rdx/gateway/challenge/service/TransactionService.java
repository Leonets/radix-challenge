package rdx.gateway.challenge.service;

import rdx.gateway.challenge.coremodel.CommittedTransactionsRequest;
import rdx.gateway.challenge.coremodel.CommittedTransactionsResponse;
import reactor.core.publisher.Mono;

public interface TransactionService {


    Mono<CommittedTransactionsResponse> transactionsPost(CommittedTransactionsRequest committedTransactionsRequest);


}
