package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A response of committed transactions which specifies the state updates which have occurred on ledger.
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CommittedTransactionsResponse {

  @JsonProperty("state_identifier")
  private StateIdentifier stateIdentifier;

  @JsonProperty("transactions")
  @Valid
  private List<CommittedTransaction> transactions = new ArrayList<>();

  public CommittedTransactionsResponse stateIdentifier(StateIdentifier stateIdentifier) {
    this.stateIdentifier = stateIdentifier;
    return this;
  }

  /**
   * Get stateIdentifier
   * @return stateIdentifier
  */
  @NotNull @Valid 
  public StateIdentifier getStateIdentifier() {
    return stateIdentifier;
  }

  public void setStateIdentifier(StateIdentifier stateIdentifier) {
    this.stateIdentifier = stateIdentifier;
  }

  public CommittedTransactionsResponse transactions(List<CommittedTransaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  public CommittedTransactionsResponse addTransactionsItem(CommittedTransaction transactionsItem) {
    this.transactions.add(transactionsItem);
    return this;
  }

  /**
   * A committed transactions list starting from the `state_identifier`.
   * @return transactions
  */
  @NotNull @Valid 
  public List<CommittedTransaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<CommittedTransaction> transactions) {
    this.transactions = transactions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommittedTransactionsResponse committedTransactionsResponse = (CommittedTransactionsResponse) o;
    return Objects.equals(this.stateIdentifier, committedTransactionsResponse.stateIdentifier) &&
        Objects.equals(this.transactions, committedTransactionsResponse.transactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stateIdentifier, transactions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommittedTransactionsResponse {\n");
    sb.append("    stateIdentifier: ").append(toIndentedString(stateIdentifier)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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

