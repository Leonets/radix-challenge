package rdx.gateway.challenge.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConverterStringToBigDecimal implements Converter<String, BigDecimal> {

    @Override
    public BigDecimal convertTo(String value) {
        return BigDecimal.valueOf(Double.parseDouble(value));
    }
}
