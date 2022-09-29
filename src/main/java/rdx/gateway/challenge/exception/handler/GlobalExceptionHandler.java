package rdx.gateway.challenge.exception.handler;

import rdx.gateway.challenge.coremodel.CommittedTransactionsResponse;
import rdx.gateway.challenge.exception.RestApiClientException;
import rdx.gateway.challenge.exception.RestApiServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RestApiClientException.class)
    public CommittedTransactionsResponse handleRestApiClientException(RestApiClientException exception, HttpServletResponse response) {
        CommittedTransactionsResponse transactionsResponse = new CommittedTransactionsResponse();
        log.info(" handleRestApiClientException " + exception.getMessage());
        return transactionsResponse;
    }

    @ExceptionHandler(RestApiServerException.class)
    public CommittedTransactionsResponse handleRestApiServerException(RestApiServerException exception, HttpServletResponse response) {
        CommittedTransactionsResponse transactionsResponse = new CommittedTransactionsResponse();
        log.info(" handleRestApiServerException " + exception.getMessage());
        return transactionsResponse;
    }

    @ExceptionHandler(Exception.class)
    public CommittedTransactionsResponse handleRestApiServerException(Exception exception, HttpServletResponse response) {
        CommittedTransactionsResponse transactionsResponse = new CommittedTransactionsResponse();
        log.info(" handleRestApiServerException " + exception.getMessage());
        return transactionsResponse;
    }
}
