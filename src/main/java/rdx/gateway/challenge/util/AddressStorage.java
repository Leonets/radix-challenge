package rdx.gateway.challenge.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import rdx.gateway.challenge.model.Transfers;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class AddressStorage {

    List<String> addresses = new ArrayList<>();

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public void addToList(List<String> addresses) {
        this.addresses.addAll(addresses);
    }

    public void removeAllFromList() {
        this.addresses.clear();
    }

    public boolean contains(String address) {
        return this.addresses.contains(address);
    }
}
