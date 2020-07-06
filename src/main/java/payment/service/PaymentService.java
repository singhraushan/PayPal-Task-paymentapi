package payment.service;

import org.springframework.stereotype.Component;
import payment.model.PaymentManifest;

public interface PaymentService {

  public PaymentManifest getTransactionJob(String transactionId);

  public PaymentManifest createTransactionJob(PaymentManifest paymentManifest);

}
