package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Hex encoded unique identifier for the substate.
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class SubstateIdentifier {

  @JsonProperty("identifier")
  private String identifier;

  public SubstateIdentifier identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

  /**
   * Get identifier
   * @return identifier
  */
  @NotNull 
  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubstateIdentifier substateIdentifier = (SubstateIdentifier) o;
    return Objects.equals(this.identifier, substateIdentifier.identifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubstateIdentifier {\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
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

