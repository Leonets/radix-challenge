package rdx.gateway.challenge.config;

import feign.codec.ErrorDecoder;
import rdx.gateway.challenge.coreclient.exception.CustomErrorDecoderForFeign;
import rdx.gateway.challenge.coreclient.service.TransactionApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactivefeign.ReactiveOptions;
import reactivefeign.client.log.DefaultReactiveLogger;
import reactivefeign.webclient.WebReactiveOptions;

import java.time.Clock;

@Configuration
public class TransactionApiClientConfig {

    private static final Logger log = LoggerFactory.getLogger(TransactionApiClientConfig.class);
    @Bean
    public ReactiveOptions reactiveOptions(TransactionTimeoutsConfig transactionsTimeoutsConfig) {
        return new WebReactiveOptions.Builder()
                .setReadTimeoutMillis(transactionsTimeoutsConfig.read())
                .setWriteTimeoutMillis(transactionsTimeoutsConfig.write())
                .setResponseTimeoutMillis(transactionsTimeoutsConfig.response())
                .build();
    }

    @Bean
    public DefaultReactiveLogger loggerListener() {
        return new DefaultReactiveLogger(Clock.systemUTC(), LoggerFactory.getLogger(TransactionApiClient.class.getName()));
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoderForFeign();
    }

}
