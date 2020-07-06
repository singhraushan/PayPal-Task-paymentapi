package payment.model;

public class PaymentManifest {

  private String transactionId;
  private PaymentDetails sourceOrigin;
  private PaymentDetails destinationOrigin;
  private double amount;
  private String createdBy;
  private Long createdTS;
  private JobStatus jobStatus;

  public PaymentManifest(PaymentDetails sourceOrigin,
      PaymentDetails destinationOrigin, double amoount, String createdBy, Long createdTS) {
    this.sourceOrigin = sourceOrigin;
    this.destinationOrigin = destinationOrigin;
    this.amount = amoount;
    this.createdBy = createdBy;
    this.createdTS = createdTS;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public PaymentDetails getSourceOrigin() {
    return sourceOrigin;
  }

  public void setSourceOrigin(PaymentDetails sourceOrigin) {
    this.sourceOrigin = sourceOrigin;
  }

  public PaymentDetails getDestinationOrigin() {
    return destinationOrigin;
  }

  public void setDestinationOrigin(PaymentDetails destinationOrigin) {
    this.destinationOrigin = destinationOrigin;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Long getCreatedTS() {
    return createdTS;
  }

  public void setCreatedTS(Long createdTS) {
    this.createdTS = createdTS;
  }

  public JobStatus getJobStatus() {
    return jobStatus;
  }

  public void setJobStatus(JobStatus jobStatus) {
    this.jobStatus = jobStatus;
  }
}
