package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EntitySetIdentifier
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class EntitySetIdentifier {

  @JsonProperty("address_regex")
  private String addressRegex;

  public EntitySetIdentifier addressRegex(String addressRegex) {
    this.addressRegex = addressRegex;
    return this;
  }

  /**
   * Get addressRegex
   * @return addressRegex
  */
  @NotNull 
  public String getAddressRegex() {
    return addressRegex;
  }

  public void setAddressRegex(String addressRegex) {
    this.addressRegex = addressRegex;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntitySetIdentifier entitySetIdentifier = (EntitySetIdentifier) o;
    return Objects.equals(this.addressRegex, entitySetIdentifier.addressRegex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressRegex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntitySetIdentifier {\n");
    sb.append("    addressRegex: ").append(toIndentedString(addressRegex)).append("\n");
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

