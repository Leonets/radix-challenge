package rdx.gateway.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Token Transfer
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class TokenTransfer {

  @JsonProperty("address")
  private String address;

  @JsonProperty("rri")
  private String rri;

  @JsonProperty("amount")
  private BigDecimal amount;

  public TokenTransfer() {
  }

  public TokenTransfer address(String address) {
    this.address = address;
    return this;
  }

  public TokenTransfer(String address, String rri, BigDecimal amount) {
    this.address = address;
    this.rri = rri;
    this.amount = amount;
  }

  /**
   * Get address
   * @return address
  */
  
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public TokenTransfer rri(String rri) {
    this.rri = rri;
    return this;
  }

  /**
   * Get rri
   * @return rri
  */
  
  public String getRri() {
    return rri;
  }

  public void setRri(String rri) {
    this.rri = rri;
  }

  public TokenTransfer amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @Valid 
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenTransfer tokenTransfer = (TokenTransfer) o;
    return Objects.equals(this.address, tokenTransfer.address) &&
        Objects.equals(this.rri, tokenTransfer.rri) &&
        Objects.equals(this.amount, tokenTransfer.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, rri, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenTransfer {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    rri: ").append(toIndentedString(rri)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

