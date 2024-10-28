package com.kendev.bridge;


import java.math.BigDecimal;

public interface PaymentProvider {
    void executePayment(BigDecimal amount);
    String getTransactionStatus(String transactionId);
}