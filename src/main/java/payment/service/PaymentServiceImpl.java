package payment.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import payment.exceptions.DatabaseException;
import payment.exceptions.TokenExpiryException;
import payment.mockdao.TransactionDao;
import payment.model.BankDetails;
import payment.model.CardDetails;
import payment.model.JobStatus;
import payment.model.PaymentManifest;
import payment.model.PaymentType;
import payment.utils.PaymentHTTPUtils;

@Service("CreditCardServiceImpl")
public class PaymentServiceImpl implements PaymentService {

  @Autowired
	private TransactionDao transactionDao;

  public PaymentManifest getTransactionJob(String transactionId) {
    return transactionDao.getTransactionJob(transactionId);
  }

  public PaymentManifest createTransactionJob(PaymentManifest paymentManifest) {

    UUID uuid = UUID.randomUUID();
    paymentManifest.setTransactionId(uuid.toString());
    paymentManifest.setJobStatus(JobStatus.INPROGRESS);

    CompletableFuture.supplyAsync(() -> processPayment(paymentManifest));

    return paymentManifest;
  }

  private long processPayment(PaymentManifest paymentManifest) {
    processSource(paymentManifest);
    processDestination(paymentManifest);
    return 0;
  }

  private void processSource(PaymentManifest paymentManifest) {

    try {
      transactionDao.createTransationJob(paymentManifest);
    } catch (DatabaseException e) {
      throw e;
    }

    if (paymentManifest.getSourceOrigin().getType() == PaymentType.BANK) {

      BankDetails bankDetails = (BankDetails) paymentManifest.getSourceOrigin();
      try {

        PaymentHTTPUtils.bankApi(bankDetails.getUrl(), bankDetails.getAuthToken(), bankDetails.getAccountNumber(),
            paymentManifest.getAmount());
      } catch (TokenExpiryException e) {
        throw e;
      }

    } else if (paymentManifest.getSourceOrigin().getType() == PaymentType.CREDIT_CARD) {

      CardDetails cardDetails = (CardDetails) paymentManifest.getSourceOrigin();
      try {
        PaymentHTTPUtils.creditCardApi(cardDetails.getUrl(), cardDetails.getAuthToken(), cardDetails.getCardNumber(),
            cardDetails.getExpiryMonth(), cardDetails.getExpiryYear(), cardDetails.getCardOwnerName(),
            cardDetails.getCvv(), paymentManifest.getAmount());

      } catch (TokenExpiryException e) {
        throw e;
      }
    }
  }

  public void processDestination(PaymentManifest paymentManifest) {
    if (paymentManifest.getDestinationOrigin().getType() == PaymentType.BANK) {

      BankDetails bankDetails = (BankDetails) paymentManifest.getDestinationOrigin();
      try {

        PaymentHTTPUtils.bankApi(bankDetails.getUrl(), bankDetails.getAuthToken(), bankDetails.getAccountNumber(),
            paymentManifest.getAmount());

        transactionDao.updateTransactionJob(paymentManifest.getTransactionId(), JobStatus.DONE);
      } catch (TokenExpiryException e) {
        transactionDao.updateTransactionJob(paymentManifest.getTransactionId(), JobStatus.FAILED);
        throw e;
      }

    } else if (paymentManifest.getDestinationOrigin().getType() == PaymentType.CREDIT_CARD) {

      CardDetails cardDetails = (CardDetails) paymentManifest.getDestinationOrigin();
      try {
        PaymentHTTPUtils.creditCardApi(cardDetails.getUrl(), cardDetails.getAuthToken(), cardDetails.getCardNumber(),
            cardDetails.getExpiryMonth(), cardDetails.getExpiryYear(), cardDetails.getCardOwnerName(),
            cardDetails.getCvv(), paymentManifest.getAmount());

      } catch (TokenExpiryException e) {
        transactionDao.updateTransactionJob(paymentManifest.getTransactionId(), JobStatus.FAILED);
        throw e;
      }
    }
  }

}
