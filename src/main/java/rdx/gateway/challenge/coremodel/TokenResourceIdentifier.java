package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * TokenResourceIdentifier
 */

@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = StakeUnitResourceIdentifier.class, name = "StakeUnit"),
  @JsonSubTypes.Type(value = TokenResourceIdentifier.class, name = "Token")
})

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class TokenResourceIdentifier extends ResourceIdentifier {

  @JsonProperty("rri")
  private String rri;

  public TokenResourceIdentifier rri(String rri) {
    this.rri = rri;
    return this;
  }

  /**
   * The Radix Resource Identifier \"RRI\" of the token.
   * @return rri
  */
  @NotNull 
  public String getRri() {
    return rri;
  }

  public void setRri(String rri) {
    this.rri = rri;
  }

  public TokenResourceIdentifier type(String type) {
    super.setType(type);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenResourceIdentifier tokenResourceIdentifier = (TokenResourceIdentifier) o;
    return Objects.equals(this.rri, tokenResourceIdentifier.rri) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rri, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenResourceIdentifier {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    rri: ").append(toIndentedString(rri)).append("\n");
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

