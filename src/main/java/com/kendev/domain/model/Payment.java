package com.kendev.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.kendev.domain.enums.PaymentStatus;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class Payment {
    private String id;
    private String transactionId;
    private BigDecimal amount;
    private PaymentStatus status;
    private LocalDateTime createdAt;
}