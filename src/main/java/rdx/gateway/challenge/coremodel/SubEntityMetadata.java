package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.Objects;

/**
 * SubEntityMetadata
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class SubEntityMetadata {

  @JsonProperty("validator_address")
  private String validatorAddress;

  @JsonProperty("epoch_unlock")
  private Long epochUnlock;

  public SubEntityMetadata validatorAddress(String validatorAddress) {
    this.validatorAddress = validatorAddress;
    return this;
  }

  /**
   * Get validatorAddress
   * @return validatorAddress
  */
  
  public String getValidatorAddress() {
    return validatorAddress;
  }

  public void setValidatorAddress(String validatorAddress) {
    this.validatorAddress = validatorAddress;
  }

  public SubEntityMetadata epochUnlock(Long epochUnlock) {
    this.epochUnlock = epochUnlock;
    return this;
  }

  /**
   * Get epochUnlock
   * @return epochUnlock
  */
  
  public Long getEpochUnlock() {
    return epochUnlock;
  }

  public void setEpochUnlock(Long epochUnlock) {
    this.epochUnlock = epochUnlock;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubEntityMetadata subEntityMetadata = (SubEntityMetadata) o;
    return Objects.equals(this.validatorAddress, subEntityMetadata.validatorAddress) &&
        Objects.equals(this.epochUnlock, subEntityMetadata.epochUnlock);
  }

  @Override
  public int hashCode() {
    return Objects.hash(validatorAddress, epochUnlock);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubEntityMetadata {\n");
    sb.append("    validatorAddress: ").append(toIndentedString(validatorAddress)).append("\n");
    sb.append("    epochUnlock: ").append(toIndentedString(epochUnlock)).append("\n");
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

