package rdx.gateway.challenge;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rdx.gateway.challenge.coremodel.CommittedTransactionsResponse;
import rdx.gateway.challenge.model.Transfers;
import rdx.gateway.challenge.service.ScheduledTasks;
import rdx.gateway.challenge.util.TransfersStorage;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class TransfersExtractorTest extends BaseTest {

	private static final Logger log = LoggerFactory.getLogger(TransfersExtractorTest.class);
	private String type;

	@Autowired
	ScheduledTasks scheduledTasks;

	@Autowired
	TransfersStorage storage;

	@Test
	void testTransfersExtractor() {
		log.info(" === START testTransfersExtractor ");

		//clear the storage
		storage.setTransfers(new ArrayList<>());

		String resultData = "src/test/resources/transaction_from_state_0.txt";
		//read model to later compare
		String inputData = readFile(resultData);
		//converto to bean
		CommittedTransactionsResponse bean = convert_to_response(inputData);

		scheduledTasks.extractData(bean);

		assertTrue(storage.getTransfers().size()>0);
		assertTrue(storage.getTransfers().size()==145);
		Transfers tx = storage.getTransfers().stream().reduce((first, second) -> second).orElse(null);
		//check exactly the latest tx amount
		assertTrue(tx.getAmount().compareTo(BigDecimal.valueOf(123L))==0);

		log.info(" === END testTransfersExtractor ");
	}

	@Test
	void testTransfersExtractorSimple() {
		log.info(" === START testTransfersExtractorSimple ");

		//clear the storage
		storage.setTransfers(new ArrayList<>());

		String resultData = "src/test/resources/transaction_example.txt";
		//read model to later compare
		String inputData = readFile(resultData);
		//converto to bean
		CommittedTransactionsResponse bean = convert_to_response(inputData);

		scheduledTasks.extractData(bean);

		assertTrue(storage.getTransfers().size()>0);
		assertTrue(storage.getTransfers().size()==48);
		Transfers tx = storage.getTransfers().stream().reduce((first, second) -> second).orElse(null);

		log.info(" === END testTransfersExtractorSimple ");
	}

}
