package com.kendev.infrastructure.entity;

import io.micronaut.data.annotation.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@MappedEntity("payments")
public class PaymentEntity {
    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;

    @MappedProperty("transaction_id")
    private String transactionId;

    private BigDecimal amount;
    private String status;

    @MappedProperty("created_at")
    private LocalDateTime createdAt;
}