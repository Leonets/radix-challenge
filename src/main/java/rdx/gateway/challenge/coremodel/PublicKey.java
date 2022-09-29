package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * PublicKey
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PublicKey {

  @JsonProperty("hex")
  private String hex;

  public PublicKey hex(String hex) {
    this.hex = hex;
    return this;
  }

  /**
   * Compressed ECSDA Public Key hex encoded.
   * @return hex
  */
  @NotNull 
  public String getHex() {
    return hex;
  }

  public void setHex(String hex) {
    this.hex = hex;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PublicKey publicKey = (PublicKey) o;
    return Objects.equals(this.hex, publicKey.hex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PublicKey {\n");
    sb.append("    hex: ").append(toIndentedString(hex)).append("\n");
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

