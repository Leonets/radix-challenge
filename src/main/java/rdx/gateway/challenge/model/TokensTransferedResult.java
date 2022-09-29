package rdx.gateway.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TokensTransferedResult
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class TokensTransferedResult {

  @JsonProperty("transfers")
  @Valid
  private List<TokenTransfer> transfers = null;

  public TokensTransferedResult transfers(List<TokenTransfer> transfers) {
    this.transfers = transfers;
    return this;
  }

  public TokensTransferedResult addTransfersItem(TokenTransfer transfersItem) {
    if (this.transfers == null) {
      this.transfers = new ArrayList<>();
    }
    this.transfers.add(transfersItem);
    return this;
  }

  /**
   * Token Transfer Container
   * @return transfers
  */
  @Valid 
  public List<TokenTransfer> getTransfers() {
    return transfers;
  }

  public void setTransfers(List<TokenTransfer> transfers) {
    this.transfers = transfers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokensTransferedResult tokensTransferedResult = (TokensTransferedResult) o;
    return Objects.equals(this.transfers, tokensTransferedResult.transfers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transfers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokensTransferedResult {\n");
    sb.append("    transfers: ").append(toIndentedString(transfers)).append("\n");
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

