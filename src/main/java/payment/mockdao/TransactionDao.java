package payment.mockdao;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;
import payment.exceptions.DatabaseException;
import payment.model.JobStatus;
import payment.model.PaymentManifest;

@Component
public class TransactionDao {

  Map<String, PaymentManifest> job = new ConcurrentHashMap<>();

  public void createTransationJob(PaymentManifest paymentManifest) {
    job.put(paymentManifest.getTransactionId(), paymentManifest);
  }

  public void updateTransactionJob(String transactionId, JobStatus jobStatus) {
    PaymentManifest paymentManifest = job.get(transactionId);

    if (Objects.isNull(paymentManifest)) {
      throw new DatabaseException("Job Not Found");
    }

    paymentManifest.setJobStatus(jobStatus);
  }

  public PaymentManifest getTransactionJob(String transactionId) {
    PaymentManifest paymentManifest = job.get(transactionId);

    if (Objects.isNull(paymentManifest)) {
      throw new DatabaseException("Job Not Found");
    }
    return paymentManifest;
  }
}
