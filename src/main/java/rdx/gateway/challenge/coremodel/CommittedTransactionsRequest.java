package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * A request to retrieve a sublist of committed transactions from the ledger.
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CommittedTransactionsRequest {

  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier;

  @JsonProperty("state_identifier")
  private PartialStateIdentifier stateIdentifier;

  @JsonProperty("limit")
  private Long limit;

  public CommittedTransactionsRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
    return this;
  }

  /**
   * Get networkIdentifier
   * @return networkIdentifier
  */
  @NotNull @Valid 
  public NetworkIdentifier getNetworkIdentifier() {
    return networkIdentifier;
  }

  public void setNetworkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
  }

  public CommittedTransactionsRequest stateIdentifier(PartialStateIdentifier stateIdentifier) {
    this.stateIdentifier = stateIdentifier;
    return this;
  }

  /**
   * Get stateIdentifier
   * @return stateIdentifier
  */
  @NotNull @Valid 
  public PartialStateIdentifier getStateIdentifier() {
    return stateIdentifier;
  }

  public void setStateIdentifier(PartialStateIdentifier stateIdentifier) {
    this.stateIdentifier = stateIdentifier;
  }

  public CommittedTransactionsRequest limit(Long limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Get limit
   * @return limit
  */
  
  public Long getLimit() {
    return limit;
  }

  public void setLimit(Long limit) {
    this.limit = limit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommittedTransactionsRequest committedTransactionsRequest = (CommittedTransactionsRequest) o;
    return Objects.equals(this.networkIdentifier, committedTransactionsRequest.networkIdentifier) &&
        Objects.equals(this.stateIdentifier, committedTransactionsRequest.stateIdentifier) &&
        Objects.equals(this.limit, committedTransactionsRequest.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, stateIdentifier, limit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommittedTransactionsRequest {\n");
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    stateIdentifier: ").append(toIndentedString(stateIdentifier)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
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

