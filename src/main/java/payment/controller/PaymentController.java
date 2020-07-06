package payment.controller;

import java.util.Objects;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import payment.model.PaymentManifest;
import payment.service.PaymentService;

@RestController
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @ApiOperation(value = "Get transactionId details")
  @RequestMapping(value = "/payment/{transactionId}", method = RequestMethod.GET)
  public PaymentManifest getTransactionStatus(@PathVariable("transactionId") String transactionId) {

    return paymentService.getTransactionJob(transactionId);
  }

  @ApiOperation(value = "Making Transaction ")
  @RequestMapping(value = "/payment", method = RequestMethod.POST)
  public PaymentManifest initiateTransaction(@RequestBody PaymentManifest paymentManifest) {

    if (Objects.isNull(paymentManifest)) {
      return null;
    }

    return paymentService.createTransactionJob(paymentManifest);
  }

}
