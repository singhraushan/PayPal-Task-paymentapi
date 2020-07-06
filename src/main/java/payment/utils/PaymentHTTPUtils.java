package payment.utils;

public class PaymentHTTPUtils {

  public static void creditCardApi(String url, String authToken, String cardNumber, int expiryMonth, int expiryYear,
      String cardOwner, int cvv, double amount) {
	// credit Card provider process here.
  }

  public static void bankApi(String url, String authToken, String accountId, double amount) {
// bank application process here.
  }

}
