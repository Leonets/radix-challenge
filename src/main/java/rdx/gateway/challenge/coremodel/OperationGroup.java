package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * OperationGroup
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class OperationGroup {

  @JsonProperty("operations")
  @Valid
  private List<Operation> operations = new ArrayList<>();

  @JsonProperty("metadata")
  private Object metadata;

  public OperationGroup operations(List<Operation> operations) {
    this.operations = operations;
    return this;
  }

  public OperationGroup addOperationsItem(Operation operationsItem) {
    this.operations.add(operationsItem);
    return this;
  }

  /**
   * A group of operations representing a complete state update.
   * @return operations
  */
  @NotNull @Valid 
  public List<Operation> getOperations() {
    return operations;
  }

  public void setOperations(List<Operation> operations) {
    this.operations = operations;
  }

  public OperationGroup metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Metadata for the operation group.
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
    OperationGroup operationGroup = (OperationGroup) o;
    return Objects.equals(this.operations, operationGroup.operations) &&
        Objects.equals(this.metadata, operationGroup.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operations, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperationGroup {\n");
    sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
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

