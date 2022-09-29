package rdx.gateway.challenge.exception;

import feign.Response;
import rdx.gateway.challenge.model.Warning;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class RestApiServerException extends Exception{
    private String requestUrl;
    private Response.Body responseBody;
    private HttpStatus responseStatus;
    private List<Warning> warningList;

    public RestApiServerException(String requestUrl, Response.Body responseBody, HttpStatus responseStatus, List<Warning> warningList) {
        this.requestUrl = requestUrl;
        this.responseBody = responseBody;
        this.responseStatus = responseStatus;
        this.warningList = warningList;
    }
}
