package rdx.gateway.challenge;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import rdx.gateway.challenge.coremodel.CommittedTransactionsRequest;
import rdx.gateway.challenge.coremodel.CommittedTransactionsResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
public class BaseTest {
    /**
     * @param filePath
     * @return
     */
    protected String readFile(String filePath) {
        String inputData = null;
        File fileIn = new File(filePath);
        try (FileInputStream input = new FileInputStream(fileIn)) {
            byte[] inputByte = input.readAllBytes();
            inputData = new String(inputByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(" Input = \n " + fileIn.getAbsolutePath());
        return inputData;
    }

    protected CommittedTransactionsResponse convert_to_response(String inputData) {
        CommittedTransactionsResponse bean = null;
        JsonMapper jsonMapper = new JsonMapper();
        jsonMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jsonMapper.enable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS);
        try {
            jsonMapper.registerModule(new JavaTimeModule());
            bean = jsonMapper.readValue(inputData, CommittedTransactionsResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return bean;
    }

    protected CommittedTransactionsRequest convert_to_request(String inputData) {
        CommittedTransactionsRequest bean = null;
        JsonMapper jsonMapper = new JsonMapper();
        jsonMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jsonMapper.enable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS);
        try {
            jsonMapper.registerModule(new JavaTimeModule());
            bean = jsonMapper.readValue(inputData, CommittedTransactionsRequest.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
