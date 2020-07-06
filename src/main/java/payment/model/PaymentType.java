package payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PaymentType {
  @JsonProperty("BANK")
  BANK,
  @JsonProperty("CREDIT_CARD")
  CREDIT_CARD
}
