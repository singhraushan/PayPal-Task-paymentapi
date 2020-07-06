package payment.exceptions;

public class TokenExpiryException extends RuntimeException {

  public TokenExpiryException(String message) {
    super(message);
  }
}
