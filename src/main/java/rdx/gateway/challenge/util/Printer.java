package rdx.gateway.challenge.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Printer {

    public String prettyPrintMe(Object output)  {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String jsonCompactString = null;
        try {
            jsonCompactString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(output);
        } catch (JsonProcessingException e) {
            log.error(" Unable to pretty print ", e);
            jsonCompactString = output.toString();
        }
        return jsonCompactString;
    }

}
