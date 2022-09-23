package com.hyphenpoc.vendingmachine.service;

import com.hyphenpoc.vendingmachine.fallback.PaymentCallback;
import com.hyphenpoc.vendingmachine.model.PaymentDetail;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    public PaymentDetail proceedPayment(PaymentDetail paymentDetail);

    public String payuCallback(PaymentCallback paymentResponse);



}
