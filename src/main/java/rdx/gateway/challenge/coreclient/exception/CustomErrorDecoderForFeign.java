package rdx.gateway.challenge.coreclient.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import rdx.gateway.challenge.exception.RestApiClientException;
import rdx.gateway.challenge.exception.RestApiServerException;
import rdx.gateway.challenge.model.Warning;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CustomErrorDecoderForFeign implements ErrorDecoder {

    @Autowired
    ObjectMapper mapper;

    @Override
    public Exception decode(String s, Response response) {
        String requestUrl = response.request().url();
        Response.Body responseBody = response.body();
        String decodeBody = "";
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());

        List<Warning> warningList = new ArrayList<>();

        if (responseStatus.is4xxClientError()) {
            try {
                decodeBody = IOUtils.toString(response.body().asInputStream(), "UTF-8");
                Warning warning = new Warning();
                warning.setErrorMessage(decodeBody);
                warningList.add(warning);
            } catch (IOException e) {
                log.error("Error reading warnings from 4xx error response", e);
                log.error("*** ERROR - requestUrl *** : " + requestUrl);
                log.error("*** ERROR - responseBody *** : " + decodeBody);
                log.error("*** ERROR - responseStatus *** : " + responseStatus);
                log.error("*** ERROR - warningList *** : " + warningList);
            }

            return new RestApiClientException(requestUrl, responseBody, responseStatus, warningList);
        } else { //http status different from 4xx
            try {
                decodeBody = IOUtils.toString(response.body().asInputStream(), "UTF-8");
                log.error("*** ERROR - responseBody *** : " + decodeBody);
                log.error("*** ERROR - responseStatus *** : " + responseStatus);
                warningList.add(new Warning()
                        .errorCode(BigDecimal.valueOf(response.status()).toString())
                        .errorMessage(new String(responseBody.asInputStream().readAllBytes()))
                        .errorType(Warning.ErrorTypeEnum.ERROR)
                        .source(requestUrl));
            } catch (IOException e) {
                log.error("Error reading body message from 5xx error response", e);
            }
            return new RestApiServerException(requestUrl, responseBody, responseStatus, warningList);
        }
    }
}
