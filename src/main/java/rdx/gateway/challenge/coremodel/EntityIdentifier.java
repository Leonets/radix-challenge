package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EntityIdentifier
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class EntityIdentifier {

  @JsonProperty("address")
  private String address;

  @JsonProperty("sub_entity")
  private SubEntity subEntity;

  public EntityIdentifier address(String address) {
    this.address = address;
    return this;
  }

  /**
   * The top level identifier for an entity.
   * @return address
  */
  @NotNull 
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public EntityIdentifier subEntity(SubEntity subEntity) {
    this.subEntity = subEntity;
    return this;
  }

  /**
   * Get subEntity
   * @return subEntity
  */
  @Valid 
  public SubEntity getSubEntity() {
    return subEntity;
  }

  public void setSubEntity(SubEntity subEntity) {
    this.subEntity = subEntity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntityIdentifier entityIdentifier = (EntityIdentifier) o;
    return Objects.equals(this.address, entityIdentifier.address) &&
        Objects.equals(this.subEntity, entityIdentifier.subEntity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, subEntity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntityIdentifier {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    subEntity: ").append(toIndentedString(subEntity)).append("\n");
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

