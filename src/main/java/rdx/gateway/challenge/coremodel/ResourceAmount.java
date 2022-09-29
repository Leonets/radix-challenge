package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * ResourceAmount
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ResourceAmount {

  @JsonProperty("value")
  private String value;

  @JsonProperty("resource_identifier")
  private ResourceIdentifier resourceIdentifier;

  public ResourceAmount value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  */
  @NotNull @Pattern(regexp = "^-?[0-9]+$") 
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public ResourceAmount resourceIdentifier(ResourceIdentifier resourceIdentifier) {
    this.resourceIdentifier = resourceIdentifier;
    return this;
  }

  /**
   * Get resourceIdentifier
   * @return resourceIdentifier
  */
  @NotNull @Valid 
  public ResourceIdentifier getResourceIdentifier() {
    return resourceIdentifier;
  }

  public void setResourceIdentifier(ResourceIdentifier resourceIdentifier) {
    this.resourceIdentifier = resourceIdentifier;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceAmount resourceAmount = (ResourceAmount) o;
    return Objects.equals(this.value, resourceAmount.value) &&
        Objects.equals(this.resourceIdentifier, resourceAmount.resourceIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, resourceIdentifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceAmount {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    resourceIdentifier: ").append(toIndentedString(resourceIdentifier)).append("\n");
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

