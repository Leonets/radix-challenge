package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * ValidatorSystemMetadata
 */

@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = EpochData.class, name = "EpochData"),
  @JsonSubTypes.Type(value = PreparedValidatorFee.class, name = "PreparedValidatorFee"),
  @JsonSubTypes.Type(value = PreparedValidatorOwner.class, name = "PreparedValidatorOwner"),
  @JsonSubTypes.Type(value = PreparedValidatorRegistered.class, name = "PreparedValidatorRegistered"),
  @JsonSubTypes.Type(value = RoundData.class, name = "RoundData"),
  @JsonSubTypes.Type(value = TokenData.class, name = "TokenData"),
  @JsonSubTypes.Type(value = TokenMetadata.class, name = "TokenMetadata"),
  @JsonSubTypes.Type(value = UnclaimedRadixEngineAddress.class, name = "UnclaimedRadixEngineAddress"),
  @JsonSubTypes.Type(value = ValidatorAllowDelegation.class, name = "ValidatorAllowDelegation"),
  @JsonSubTypes.Type(value = ValidatorBFTData.class, name = "ValidatorBFTData"),
  @JsonSubTypes.Type(value = ValidatorData.class, name = "ValidatorData"),
  @JsonSubTypes.Type(value = ValidatorMetadata.class, name = "ValidatorMetadata"),
  @JsonSubTypes.Type(value = ValidatorSystemMetadata.class, name = "ValidatorSystemMetadata"),
  @JsonSubTypes.Type(value = VirtualParentData.class, name = "VirtualParentData")
})

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ValidatorSystemMetadata extends DataObject {

  @JsonProperty("data")
  private String data;

  public ValidatorSystemMetadata data(String data) {
    this.data = data;
    return this;
  }

  /**
   * A hex encoded byte array.
   * @return data
  */
  @NotNull 
  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public ValidatorSystemMetadata type(String type) {
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
    ValidatorSystemMetadata validatorSystemMetadata = (ValidatorSystemMetadata) o;
    return Objects.equals(this.data, validatorSystemMetadata.data) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidatorSystemMetadata {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

