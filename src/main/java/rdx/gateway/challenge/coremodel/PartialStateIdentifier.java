package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * PartialStateIdentifier
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PartialStateIdentifier {

  @JsonProperty("state_version")
  private Long stateVersion;

  @JsonProperty("transaction_accumulator")
  private String transactionAccumulator;

  public PartialStateIdentifier stateVersion(Long stateVersion) {
    this.stateVersion = stateVersion;
    return this;
  }

  /**
   * Get stateVersion
   * @return stateVersion
  */
  @NotNull 
  public Long getStateVersion() {
    return stateVersion;
  }

  public void setStateVersion(Long stateVersion) {
    this.stateVersion = stateVersion;
  }

  public PartialStateIdentifier transactionAccumulator(String transactionAccumulator) {
    this.transactionAccumulator = transactionAccumulator;
    return this;
  }

  /**
   * Accumulator hash representing all transactions which occurred up to `state_version`. Hex encoded.
   * @return transactionAccumulator
  */
  
  public String getTransactionAccumulator() {
    return transactionAccumulator;
  }

  public void setTransactionAccumulator(String transactionAccumulator) {
    this.transactionAccumulator = transactionAccumulator;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartialStateIdentifier partialStateIdentifier = (PartialStateIdentifier) o;
    return Objects.equals(this.stateVersion, partialStateIdentifier.stateVersion) &&
        Objects.equals(this.transactionAccumulator, partialStateIdentifier.transactionAccumulator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stateVersion, transactionAccumulator);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartialStateIdentifier {\n");
    sb.append("    stateVersion: ").append(toIndentedString(stateVersion)).append("\n");
    sb.append("    transactionAccumulator: ").append(toIndentedString(transactionAccumulator)).append("\n");
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

