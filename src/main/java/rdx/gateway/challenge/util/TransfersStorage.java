package rdx.gateway.challenge.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import rdx.gateway.challenge.model.Transfers;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class TransfersStorage {

    List<Transfers> transfers = new ArrayList<>();

    public List<Transfers> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfers> transfers) {
        this.transfers = transfers;
    }

    public void addToList(List<Transfers> transfers) {
        this.transfers.addAll(transfers);
    }
}
