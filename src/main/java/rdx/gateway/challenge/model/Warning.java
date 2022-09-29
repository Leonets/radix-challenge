package rdx.gateway.challenge.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Generated;

/**
 * Includes all kind of returned warnings
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Warning {

  @JsonProperty("errorCode")
  private String errorCode;

  /**
   * Gets or Sets errorType
   */
  public enum ErrorTypeEnum {
    ERROR("ERROR"),

    WARNING("WARNING"),

    MESSAGE("MESSAGE");

    private String value;

    ErrorTypeEnum(String value) {
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
    public static ErrorTypeEnum fromValue(String value) {
      for (ErrorTypeEnum b : ErrorTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("errorType")
  private ErrorTypeEnum errorType;

  @JsonProperty("source")
  private String source;

  @JsonProperty("errorMessage")
  private String errorMessage;

  public Warning errorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * Get errorCode
   * @return errorCode
   */

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public Warning errorType(ErrorTypeEnum errorType) {
    this.errorType = errorType;
    return this;
  }

  /**
   * Get errorType
   * @return errorType
   */

  public ErrorTypeEnum getErrorType() {
    return errorType;
  }

  public void setErrorType(ErrorTypeEnum errorType) {
    this.errorType = errorType;
  }

  public Warning source(String source) {
    this.source = source;
    return this;
  }

  /**
   * Get source
   * @return source
   */

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Warning errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * Get errorMessage
   * @return errorMessage
   */

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Warning warning = (Warning) o;
    return Objects.equals(this.errorCode, warning.errorCode) &&
            Objects.equals(this.errorType, warning.errorType) &&
            Objects.equals(this.source, warning.source) &&
            Objects.equals(this.errorMessage, warning.errorMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCode, errorType, source, errorMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Warning {\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    errorType: ").append(toIndentedString(errorType)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
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

