package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Substate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Substate {

  /**
   * The type of substate operation (equivalent to UTXO create/spend).
   */
  public enum SubstateOperationEnum {
    BOOTUP("BOOTUP"),
    
    SHUTDOWN("SHUTDOWN");

    private String value;

    SubstateOperationEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SubstateOperationEnum fromValue(String value) {
      for (SubstateOperationEnum b : SubstateOperationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("substate_operation")
  private SubstateOperationEnum substateOperation;

  @JsonProperty("substate_identifier")
  private SubstateIdentifier substateIdentifier;

  public Substate substateOperation(SubstateOperationEnum substateOperation) {
    this.substateOperation = substateOperation;
    return this;
  }

  /**
   * The type of substate operation (equivalent to UTXO create/spend).
   * @return substateOperation
  */
  @NotNull 
  public SubstateOperationEnum getSubstateOperation() {
    return substateOperation;
  }

  public void setSubstateOperation(SubstateOperationEnum substateOperation) {
    this.substateOperation = substateOperation;
  }

  public Substate substateIdentifier(SubstateIdentifier substateIdentifier) {
    this.substateIdentifier = substateIdentifier;
    return this;
  }

  /**
   * Get substateIdentifier
   * @return substateIdentifier
  */
  @NotNull @Valid 
  public SubstateIdentifier getSubstateIdentifier() {
    return substateIdentifier;
  }

  public void setSubstateIdentifier(SubstateIdentifier substateIdentifier) {
    this.substateIdentifier = substateIdentifier;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Substate substate = (Substate) o;
    return Objects.equals(this.substateOperation, substate.substateOperation) &&
        Objects.equals(this.substateIdentifier, substate.substateIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(substateOperation, substateIdentifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Substate {\n");
    sb.append("    substateOperation: ").append(toIndentedString(substateOperation)).append("\n");
    sb.append("    substateIdentifier: ").append(toIndentedString(substateIdentifier)).append("\n");
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

