package rdx.gateway.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Transfers {

    @JsonProperty("address")
    private String address;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("rri")
    private String rri;

    public Transfers(String address, BigDecimal convertTo, String rri) {
        this.amount = convertTo;
        this.address = address;
        this.rri = rri;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRri() {
        return rri;
    }

    public void setRri(String rri) {
        this.rri = rri;
    }
}
