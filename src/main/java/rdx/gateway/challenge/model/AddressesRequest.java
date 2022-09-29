package rdx.gateway.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Container object for the Addresses
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class AddressesRequest {

  @JsonProperty("Address")
  @Valid
  private List<String> address = new ArrayList<>();

  public AddressesRequest address(List<String> address) {
    this.address = address;
    return this;
  }

  public AddressesRequest addAddressItem(String addressItem) {
    this.address.add(addressItem);
    return this;
  }

  /**
   * address to be monitored
   * @return address
  */
  @NotNull 
  public List<String> getAddress() {
    return address;
  }

  public void setAddress(List<String> address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressesRequest addressesRequest = (AddressesRequest) o;
    return Objects.equals(this.address, addressesRequest.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressesRequest {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

