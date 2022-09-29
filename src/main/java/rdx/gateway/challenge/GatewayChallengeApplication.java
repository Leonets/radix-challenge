package rdx.gateway.challenge;

import rdx.gateway.challenge.config.TransactionTimeoutsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@EnableReactiveFeignClients
@SpringBootApplication
@EnableConfigurationProperties(TransactionTimeoutsConfig.class)
@EnableScheduling
public class GatewayChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayChallengeApplication.class, args);
    }

}
