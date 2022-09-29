package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * CommittedTransactionMetadata
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CommittedTransactionMetadata {

  @JsonProperty("size")
  private Integer size;

  @JsonProperty("hex")
  private String hex;

  @JsonProperty("fee")
  private ResourceAmount fee;

  @JsonProperty("signed_by")
  private PublicKey signedBy;

  @JsonProperty("message")
  private String message;

  public CommittedTransactionMetadata size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * The size of the transaction in bytes.
   * @return size
  */
  @NotNull 
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public CommittedTransactionMetadata hex(String hex) {
    this.hex = hex;
    return this;
  }

  /**
   * The raw transaction bytes in hex encoding.
   * @return hex
  */
  @NotNull 
  public String getHex() {
    return hex;
  }

  public void setHex(String hex) {
    this.hex = hex;
  }

  public CommittedTransactionMetadata fee(ResourceAmount fee) {
    this.fee = fee;
    return this;
  }

  /**
   * Get fee
   * @return fee
  */
  @Valid 
  public ResourceAmount getFee() {
    return fee;
  }

  public void setFee(ResourceAmount fee) {
    this.fee = fee;
  }

  public CommittedTransactionMetadata signedBy(PublicKey signedBy) {
    this.signedBy = signedBy;
    return this;
  }

  /**
   * Get signedBy
   * @return signedBy
  */
  @Valid 
  public PublicKey getSignedBy() {
    return signedBy;
  }

  public void setSignedBy(PublicKey signedBy) {
    this.signedBy = signedBy;
  }

  public CommittedTransactionMetadata message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Optional hex encoded byte array in the transaction.
   * @return message
  */
  
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommittedTransactionMetadata committedTransactionMetadata = (CommittedTransactionMetadata) o;
    return Objects.equals(this.size, committedTransactionMetadata.size) &&
        Objects.equals(this.hex, committedTransactionMetadata.hex) &&
        Objects.equals(this.fee, committedTransactionMetadata.fee) &&
        Objects.equals(this.signedBy, committedTransactionMetadata.signedBy) &&
        Objects.equals(this.message, committedTransactionMetadata.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(size, hex, fee, signedBy, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommittedTransactionMetadata {\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    hex: ").append(toIndentedString(hex)).append("\n");
    sb.append("    fee: ").append(toIndentedString(fee)).append("\n");
    sb.append("    signedBy: ").append(toIndentedString(signedBy)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

