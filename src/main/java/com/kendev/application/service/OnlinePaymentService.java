package com.kendev.application.service;

import com.kendev.application.dto.PaymentRequest;
import com.kendev.application.dto.PaymentResponse;
import com.kendev.bridge.PaymentProvider;
import com.kendev.domain.enums.PaymentStatus;
import jakarta.inject.Singleton;

@Singleton
public class OnlinePaymentService implements PaymentService {
    private final PaymentProvider paymentProvider;

    public OnlinePaymentService(PaymentProvider paymentProvider) {
        this.paymentProvider = paymentProvider;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        validateRequest(request);

        try {
            paymentProvider.executePayment(request.getAmount());
            return PaymentResponse.builder()
                    .status(PaymentStatus.PROCESSED)
                    .message("Payment processed successfully")
                    .build();
        } catch (Exception e) {
            return PaymentResponse.builder()
                    .status(PaymentStatus.FAILED)
                    .message("Payment processing failed: " + e.getMessage())
                    .build();
        }
    }

    @Override
    public PaymentResponse getPaymentStatus(String transactionId) {
        String status = paymentProvider.getTransactionStatus(transactionId);
        return PaymentResponse.builder()
                .transactionId(transactionId)
                .status(PaymentStatus.valueOf(status))
                .build();
    }

    private void validateRequest(PaymentRequest request) {
        if (request.getAmount() == null || request.getAmount().signum() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }
}