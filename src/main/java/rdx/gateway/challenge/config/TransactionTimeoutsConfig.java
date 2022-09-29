package rdx.gateway.challenge.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "coreapi.api.timeouts-millis")
public record TransactionTimeoutsConfig(Long read, Long write, Long response) {
}
