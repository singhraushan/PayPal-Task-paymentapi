package payment.model;

public class BankDetails extends PaymentDetails {

  private String accountNumber;

  public BankDetails(String url, String authToken, String refreshToken, PaymentType type, String accountNumber) {
    super(url, authToken, refreshToken, type);
    this.accountNumber = accountNumber;
  }

  public String getAccountNumber() {
    return accountNumber;
  }
}
