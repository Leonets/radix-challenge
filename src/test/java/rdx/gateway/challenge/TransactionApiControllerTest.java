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
import rdx.gateway.challenge.coremodel.CommittedTransaction;
import rdx.gateway.challenge.coremodel.CommittedTransactionsResponse;
import rdx.gateway.challenge.model.TokenTransfer;
import rdx.gateway.challenge.model.TokensTransferedResult;
import rdx.gateway.challenge.util.Printer;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9090)
@AutoConfigureWebTestClient(timeout = "30000")
@Slf4j
class TransactionApiControllerTest extends BaseTest {

    @Autowired
    private WebTestClient webClient;

    @Autowired
    private Printer printer;

    public static String testUrl = "/transactions";
    public static String contentType = "application/json";

    @Test
    void transactionTest() {
        //Here I set the response body and also the request body
        String requestContent = readFile("src/test/resources/transaction_request.txt");
        String responseContent = readFile("src/test/resources/transaction_from_state_0_simpler.txt");

        stubFor(post(urlEqualTo(testUrl))
                .withHeader("Content-Type", equalTo("application/json"))
                .withRequestBody(matchingJsonPath("$", equalToJson(REQUEST_BODY)))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(responseContent
                        )));

        //Here I set the request body (REQUEST_BODY, json syntax) sent to /v1/transactions service
        //I also set what I expect back (CommittedTransactionsResponse)
        //And also I can set assertions
        webClient
                .method(HttpMethod.GET)
                .uri("/v1/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(REQUEST_BODY))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(CommittedTransactionsResponse.class)
                .consumeWith(result -> {
                    assertThat(Objects.requireNonNull(result.getResponseBody()).getTransactions());
                    count_transactions(result.getResponseBody().getTransactions());
                    assertTrue(result.getResponseBody().getTransactions().size()==2);
                    pretty_print(result.getResponseBody());
                });


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
    }

    private void pretty_print(TokensTransferedResult result) {
        log.info(" Response received = \n" + printer.prettyPrintMe(result));
    }

    private void count_token_transfers(@Valid List<TokenTransfer> transfers) {
        log.info(" Token Transfers received = " + transfers.size());
    }

    private void pretty_print(CommittedTransactionsResponse result) {
        log.info(" Response received = \n" + printer.prettyPrintMe(result));
    }

    private void count_transactions(List<CommittedTransaction> transactions) {
        log.info(" Tx received = " + transactions.size());
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

    protected String ile(String filePath) {
        String inputData = null;
        File fileIn = new File(filePath);
        try (FileInputStream input = new FileInputStream(fileIn)) {
            byte[] inputByte = input.readAllBytes();
            inputData = new String(inputByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(" Input file = \n " + fileIn.getAbsolutePath());
        return inputData;
    }
}