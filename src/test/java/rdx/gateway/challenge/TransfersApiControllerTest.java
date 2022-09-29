package rdx.gateway.challenge;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import rdx.gateway.challenge.coremodel.CommittedTransactionsRequest;
import rdx.gateway.challenge.model.TokenTransfer;
import rdx.gateway.challenge.model.TokensTransferedResult;
import rdx.gateway.challenge.util.Printer;
import rdx.gateway.challenge.service.ScheduledTasks;
import rdx.gateway.challenge.util.TransfersStorage;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9090)
@AutoConfigureWebTestClient(timeout = "30000")
@Slf4j
class TransfersApiControllerTest extends BaseTest {

    @Autowired
    private WebTestClient webClient;

    @Autowired
    private Printer printer;

    @Autowired
    ScheduledTasks scheduledTasks;

    @Autowired
    TransfersStorage storage;

    public static String testUrl = "/transactions";
    public static String contentType = "application/json";

    @Test
    void transfersTest() {
        //Here I set the request body
        String inputFilePath = "src/test/resources/transaction_request.txt";
        String requestContent = readFile(inputFilePath);
        //here I set the simulated response from the Core api
        String responseContent = readFile("src/test/resources/transaction_example.txt");

        //here I stub the request/response to the Core Api
        stubFor(post(urlEqualTo(testUrl))
                .withHeader("Content-Type", equalTo("application/json"))
                .withRequestBody(matchingJsonPath("$", equalToJson(REQUEST_BODY)))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(responseContent
                        )));

        //read model to later compare
        String inputData = readFile(inputFilePath);
        //convert to bean
        CommittedTransactionsRequest bean = convert_to_request(inputData);

        //here we trigger the scheduler that will be asking for transactions to the Core api
        scheduledTasks.transfersGet(bean);

        //Here I execute the get request to my api
        webClient
                .method(HttpMethod.GET)
                .uri("/v1/transfers")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(REQUEST_BODY))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(TokensTransferedResult.class)
                .consumeWith(result -> {
                    assertThat(Objects.requireNonNull(result.getResponseBody()).getTransfers());
                    count_token_transfers(result.getResponseBody().getTransfers());
                    pretty_print(result.getResponseBody());
                });

        //here I change that the scheduler had found the exact number of transfers contained in the example file
        assertTrue(storage.getTransfers().size()==48);
    }

    private void pretty_print(TokensTransferedResult result) {
        log.info(" Response received = \n" + printer.prettyPrintMe(result));
    }

    private void count_token_transfers(@Valid List<TokenTransfer> transfers) {
        log.info(" Token Transfers received = " + transfers.size());
    }

    private static final String REQUEST_BODY = """
            {
                  "network_identifier": {
                    "network": "stokenet"
                  },
                  "state_identifier": {
                    "state_version": 0,
                    "transaction_accumulator":"0000000000000000000000000000000000000000000000000000000000000000"
                  },
                  "limit": 100
           }
            """;

}