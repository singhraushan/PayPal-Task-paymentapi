package payment.model;

public class CardDetails extends PaymentDetails {

  private String cardNumber;
  private String cardOwnerName;
  private int expiryMonth;
  private int expiryYear;
  private int cvv;

  public CardDetails(String url, String authToken, String refreshToken, PaymentType type, String cardNumber,
      String cardOwnerName,
      int expiryMonth,
      int expiryYear,
      int cvv) {

    super(url, authToken, refreshToken, type);
    this.cardNumber = cardNumber;
    this.cardOwnerName = cardOwnerName;
    this.expiryMonth = expiryMonth;
    this.expiryYear = expiryYear;
    this.cvv = cvv;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public String getCardOwnerName() {
    return cardOwnerName;
  }

  public int getExpiryMonth() {
    return expiryMonth;
  }

  public int getExpiryYear() {
    return expiryYear;
  }

  public int getCvv() {
    return cvv;
  }
}
