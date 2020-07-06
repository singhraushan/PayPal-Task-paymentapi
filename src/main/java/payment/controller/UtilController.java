package payment.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payment.model.ParagraphDetails;
import payment.model.PaymentManifest;
import payment.service.UtilService;

@RestController
public class UtilController {

    @Autowired
    UtilService utilService;

    @ApiOperation(value = "Reverse and get word count")
    @RequestMapping(value = "/paragraph/", method = RequestMethod.GET)
    public ParagraphDetails getReversedParagraphAndWordCount(@RequestHeader String paragraph) {

        return utilService.getParagraphDetails(paragraph);
    }

}
