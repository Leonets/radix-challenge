package rdx.gateway.challenge;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rdx.gateway.challenge.model.TokenTransfer;
import rdx.gateway.challenge.model.Transfers;
import rdx.gateway.challenge.util.mapper.TransfersMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransfersMapperTest {

    private static final Logger log = LoggerFactory.getLogger(TransfersMapperTest.class);

    @Test
    void testMapping() {

        List<Transfers> lista = new ArrayList<>();
        String add = "address";
        BigDecimal big = BigDecimal.ZERO;
        String rri = "rdi";

        lista.add(new Transfers(add,big,rri));

        List<TokenTransfer> output = TransfersMapper.MAPPER.toTransfersList(lista);

        for (TokenTransfer transfer: output
             ) {
            log.info(" address = " + transfer.getAddress());
            log.info(" amount = " + transfer.getAmount());
            log.info(" rri = " + transfer.getRri());
            assertEquals(add,transfer.getAddress());
            assertEquals(big, transfer.getAmount());
            assertEquals(rri, transfer.getRri());
        }
    }
}
