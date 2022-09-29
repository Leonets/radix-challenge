package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * TokenData
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
public class TokenData extends DataObject {

  @JsonProperty("granularity")
  private String granularity;

  @JsonProperty("is_mutable")
  private Boolean isMutable;

  @JsonProperty("owner")
  private EntityIdentifier owner;

  public TokenData granularity(String granularity) {
    this.granularity = granularity;
    return this;
  }

  /**
   * Get granularity
   * @return granularity
  */
  @NotNull @Pattern(regexp = "^-?[0-9]+$") 
  public String getGranularity() {
    return granularity;
  }

  public void setGranularity(String granularity) {
    this.granularity = granularity;
  }

  public TokenData isMutable(Boolean isMutable) {
    this.isMutable = isMutable;
    return this;
  }

  /**
   * If true, the `owner` is able to mint/burn tokens. Otherwise, the token is a fixed supply token.
   * @return isMutable
  */
  @NotNull 
  public Boolean getIsMutable() {
    return isMutable;
  }

  public void setIsMutable(Boolean isMutable) {
    this.isMutable = isMutable;
  }

  public TokenData owner(EntityIdentifier owner) {
    this.owner = owner;
    return this;
  }

  /**
   * Get owner
   * @return owner
  */
  @Valid 
  public EntityIdentifier getOwner() {
    return owner;
  }

  public void setOwner(EntityIdentifier owner) {
    this.owner = owner;
  }

  public TokenData type(String type) {
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
    TokenData tokenData = (TokenData) o;
    return Objects.equals(this.granularity, tokenData.granularity) &&
        Objects.equals(this.isMutable, tokenData.isMutable) &&
        Objects.equals(this.owner, tokenData.owner) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(granularity, isMutable, owner, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenData {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    granularity: ").append(toIndentedString(granularity)).append("\n");
    sb.append("    isMutable: ").append(toIndentedString(isMutable)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
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

