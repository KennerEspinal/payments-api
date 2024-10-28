package com.kendev.application.dto;

import com.kendev.domain.enums.PaymentStatus;
import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Payment response information")
public class PaymentResponse {
    @Schema(description = "Transaction identifier", example = "TRX-123456")
    private String transactionId;

    @Schema(description = "Payment status", example = "PROCESSED")
    private PaymentStatus status;

    @Schema(description = "Response message", example = "Payment processed successfully")
    private String message;
}