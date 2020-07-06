package payment.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = BankDetails.class, name = "BANK"),
    @JsonSubTypes.Type(value = CardDetails.class, name = "CREDIT_CARD")
})
public abstract class PaymentDetails {
  private String url;
  private String authToken;
  private String refreshToken;
  private PaymentType type;


  public PaymentDetails(String url, String authToken, String refreshToken, PaymentType type) {
    this.url = url;
    this.authToken = authToken;
    this.refreshToken = refreshToken;
    this.type = type;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getAuthToken() {
    return authToken;
  }

  public void setAuthToken(String authToken) {
    this.authToken = authToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public PaymentType getType() {
    return type;
  }

  public void setType(PaymentType type) {
    this.type = type;
  }

}

