package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * NetworkIdentifier
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class NetworkIdentifier {

  @JsonProperty("network")
  private String network;

  public NetworkIdentifier network(String network) {
    this.network = network;
    return this;
  }

  /**
   * Get network
   * @return network
  */
  @NotNull 
  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkIdentifier networkIdentifier = (NetworkIdentifier) o;
    return Objects.equals(this.network, networkIdentifier.network);
  }

  @Override
  public int hashCode() {
    return Objects.hash(network);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkIdentifier {\n");
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
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

