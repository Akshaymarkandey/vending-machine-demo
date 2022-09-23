package com.hyphenpoc.vendingmachine.controller;

import com.hyphenpoc.vendingmachine.fallback.PaymentCallback;
import com.hyphenpoc.vendingmachine.model.PaymentDetail;
import com.hyphenpoc.vendingmachine.paymentutil.PaymentMode;
import com.hyphenpoc.vendingmachine.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Used @CrossOrigin because we where getting the CORS Error.
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    //this method is used for the payment details
    @PostMapping(path = "/payment-details")
    public @ResponseBody
    PaymentDetail proceedPayment(@RequestBody PaymentDetail paymentDetail){
        return paymentService.proceedPayment(paymentDetail);
    }
    // this method is used for the payment response details
    @RequestMapping(path = "/payment-response", method = RequestMethod.POST)
    public @ResponseBody String payuCallback(@RequestParam String mihpayid, @RequestParam String status, @RequestParam PaymentMode mode, @RequestParam String txnid, @RequestParam String hash){
        PaymentCallback paymentCallback = new PaymentCallback();
        paymentCallback.setMihpayid(mihpayid);
        paymentCallback.setTxnid(txnid);
        paymentCallback.setMode(mode);
        paymentCallback.setHash(hash);
        paymentCallback.setStatus(status);
        return paymentService.payuCallback(paymentCallback);
    }
}