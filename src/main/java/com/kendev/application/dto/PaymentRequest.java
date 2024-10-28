package com.kendev.application.dto;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Introspected
@Schema(description = "Payment request information")
public class PaymentRequest {
    @Schema(description = "Amount to be paid", example = "100.00", required = true)
    private BigDecimal amount;

    @Schema(description = "Currency code", example = "USD", required = true)
    private String currency;

    @Schema(description = "Payment description", example = "Product purchase")
    private String description;
}