package com.kendev.bridge;

import com.kendev.infrastructure.entity.PaymentEntity;
import com.kendev.infrastructure.repository.PaymentRepository;
import jakarta.inject.Singleton;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Singleton
public class MySQLPaymentProvider implements PaymentProvider {
    private final PaymentRepository paymentRepository;

    public MySQLPaymentProvider(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void executePayment(BigDecimal amount) {
        PaymentEntity payment = new PaymentEntity();
        payment.setTransactionId(generateTransactionId());
        payment.setAmount(amount);
        payment.setStatus("PROCESSED");
        payment.setCreatedAt(LocalDateTime.now());
        paymentRepository.save(payment);
    }

    @Override
    public String getTransactionStatus(String transactionId) {
        PaymentEntity payment = paymentRepository.findByTransactionId(transactionId);
        return payment != null ? payment.getStatus() : "NOT_FOUND";
    }

    private String generateTransactionId() {
        return "TRX-" + System.currentTimeMillis();
    }
}