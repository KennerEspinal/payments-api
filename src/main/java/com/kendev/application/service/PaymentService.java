package com.kendev.application.service;

import com.kendev.application.dto.PaymentRequest;
import com.kendev.application.dto.PaymentResponse;

public interface PaymentService {
    PaymentResponse processPayment(PaymentRequest request);
    PaymentResponse getPaymentStatus(String transactionId);
}
