package rdx.gateway.challenge.coremodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A transaction which has been committed on ledger.
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CommittedTransaction {

  @JsonProperty("transaction_identifier")
  private TransactionIdentifier transactionIdentifier;

  @JsonProperty("committed_state_identifier")
  private StateIdentifier committedStateIdentifier;

  @JsonProperty("operation_groups")
  @Valid
  private List<OperationGroup> operationGroups = new ArrayList<>();

  @JsonProperty("metadata")
  private CommittedTransactionMetadata metadata;

  public CommittedTransaction transactionIdentifier(TransactionIdentifier transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
    return this;
  }

  /**
   * Get transactionIdentifier
   * @return transactionIdentifier
  */
  @NotNull @Valid 
  public TransactionIdentifier getTransactionIdentifier() {
    return transactionIdentifier;
  }

  public void setTransactionIdentifier(TransactionIdentifier transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
  }

  public CommittedTransaction committedStateIdentifier(StateIdentifier committedStateIdentifier) {
    this.committedStateIdentifier = committedStateIdentifier;
    return this;
  }

  /**
   * Get committedStateIdentifier
   * @return committedStateIdentifier
  */
  @NotNull @Valid 
  public StateIdentifier getCommittedStateIdentifier() {
    return committedStateIdentifier;
  }

  public void setCommittedStateIdentifier(StateIdentifier committedStateIdentifier) {
    this.committedStateIdentifier = committedStateIdentifier;
  }

  public CommittedTransaction operationGroups(List<OperationGroup> operationGroups) {
    this.operationGroups = operationGroups;
    return this;
  }

  public CommittedTransaction addOperationGroupsItem(OperationGroup operationGroupsItem) {
    this.operationGroups.add(operationGroupsItem);
    return this;
  }

  /**
   * Transactions are split into operation groups which are roughly equivalent to ledger accounting entries where all credits have an equivalent debit amount.
   * @return operationGroups
  */
  @NotNull @Valid 
  public List<OperationGroup> getOperationGroups() {
    return operationGroups;
  }

  public void setOperationGroups(List<OperationGroup> operationGroups) {
    this.operationGroups = operationGroups;
  }

  public CommittedTransaction metadata(CommittedTransactionMetadata metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  */
  @NotNull @Valid 
  public CommittedTransactionMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(CommittedTransactionMetadata metadata) {
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
    CommittedTransaction committedTransaction = (CommittedTransaction) o;
    return Objects.equals(this.transactionIdentifier, committedTransaction.transactionIdentifier) &&
        Objects.equals(this.committedStateIdentifier, committedTransaction.committedStateIdentifier) &&
        Objects.equals(this.operationGroups, committedTransaction.operationGroups) &&
        Objects.equals(this.metadata, committedTransaction.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionIdentifier, committedStateIdentifier, operationGroups, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommittedTransaction {\n");
    sb.append("    transactionIdentifier: ").append(toIndentedString(transactionIdentifier)).append("\n");
    sb.append("    committedStateIdentifier: ").append(toIndentedString(committedStateIdentifier)).append("\n");
    sb.append("    operationGroups: ").append(toIndentedString(operationGroups)).append("\n");
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

