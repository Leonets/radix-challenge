package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Data
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Data {

  /**
   * Data action to take on `data_object`.
   */
  public enum ActionEnum {
    CREATE("CREATE"),
    
    DELETE("DELETE");

    private String value;

    ActionEnum(String value) {
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
    public static ActionEnum fromValue(String value) {
      for (ActionEnum b : ActionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("action")
  private ActionEnum action;

  @JsonProperty("data_object")
  private DataObject dataObject;

  public Data action(ActionEnum action) {
    this.action = action;
    return this;
  }

  /**
   * Data action to take on `data_object`.
   * @return action
  */
  @NotNull 
  public ActionEnum getAction() {
    return action;
  }

  public void setAction(ActionEnum action) {
    this.action = action;
  }

  public Data dataObject(DataObject dataObject) {
    this.dataObject = dataObject;
    return this;
  }

  /**
   * Get dataObject
   * @return dataObject
  */
  @NotNull @Valid 
  public DataObject getDataObject() {
    return dataObject;
  }

  public void setDataObject(DataObject dataObject) {
    this.dataObject = dataObject;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Data data = (Data) o;
    return Objects.equals(this.action, data.action) &&
        Objects.equals(this.dataObject, data.dataObject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, dataObject);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Data {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    dataObject: ").append(toIndentedString(dataObject)).append("\n");
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

