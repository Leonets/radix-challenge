package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * SubEntity
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class SubEntity {

  @JsonProperty("address")
  private String address;

  @JsonProperty("metadata")
  private SubEntityMetadata metadata;

  public SubEntity address(String address) {
    this.address = address;
    return this;
  }

  /**
   * The subentity.
   * @return address
  */
  @NotNull 
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public SubEntity metadata(SubEntityMetadata metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  */
  @Valid 
  public SubEntityMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(SubEntityMetadata metadata) {
    this.metadata = metadata;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubEntity subEntity = (SubEntity) o;
    return Objects.equals(this.address, subEntity.address) &&
        Objects.equals(this.metadata, subEntity.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubEntity {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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

