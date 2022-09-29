package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Operation
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Operation {

  @JsonProperty("type")
  private String type;

  @JsonProperty("entity_identifier")
  private EntityIdentifier entityIdentifier;

  @JsonProperty("substate")
  private Substate substate;

  @JsonProperty("amount")
  private ResourceAmount amount;

  @JsonProperty("data")
  private Data data;

  @JsonProperty("metadata")
  private Object metadata;

  public Operation type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The type of operation: Resource, Data, or ResourceAndData.
   * @return type
  */
  @NotNull 
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Operation entityIdentifier(EntityIdentifier entityIdentifier) {
    this.entityIdentifier = entityIdentifier;
    return this;
  }

  /**
   * Get entityIdentifier
   * @return entityIdentifier
  */
  @NotNull @Valid 
  public EntityIdentifier getEntityIdentifier() {
    return entityIdentifier;
  }

  public void setEntityIdentifier(EntityIdentifier entityIdentifier) {
    this.entityIdentifier = entityIdentifier;
  }

  public Operation substate(Substate substate) {
    this.substate = substate;
    return this;
  }

  /**
   * Get substate
   * @return substate
  */
  @Valid 
  public Substate getSubstate() {
    return substate;
  }

  public void setSubstate(Substate substate) {
    this.substate = substate;
  }

  public Operation amount(ResourceAmount amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @Valid 
  public ResourceAmount getAmount() {
    return amount;
  }

  public void setAmount(ResourceAmount amount) {
    this.amount = amount;
  }

  public Operation data(Data data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @Valid 
  public Data getData() {
    return data;
  }

  public void setData(Data data) {
    this.data = data;
  }

  public Operation metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Metadata for the operation.
   * @return metadata
  */
  
  public Object getMetadata() {
    return metadata;
  }

  public void setMetadata(Object metadata) {
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
    Operation operation = (Operation) o;
    return Objects.equals(this.type, operation.type) &&
        Objects.equals(this.entityIdentifier, operation.entityIdentifier) &&
        Objects.equals(this.substate, operation.substate) &&
        Objects.equals(this.amount, operation.amount) &&
        Objects.equals(this.data, operation.data) &&
        Objects.equals(this.metadata, operation.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, entityIdentifier, substate, amount, data, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Operation {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    entityIdentifier: ").append(toIndentedString(entityIdentifier)).append("\n");
    sb.append("    substate: ").append(toIndentedString(substate)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

