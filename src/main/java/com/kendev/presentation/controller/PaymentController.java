package com.kendev.presentation.controller;

import com.kendev.application.dto.PaymentRequest;
import com.kendev.application.dto.PaymentResponse;
import com.kendev.application.service.PaymentService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller("/api/payments")
@Tag(name = "Payments", description = "Payment management endpoints")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Post
    @Operation(
            summary = "Process payment",
            description = "Process a new payment transaction"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Payment processed successfully",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PaymentResponse.class)
            )
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid payment request"
    )
    public HttpResponse<PaymentResponse> processPayment(
            @RequestBody(description = "Payment request details")
            @Body PaymentRequest request
    ) {
        PaymentResponse response = paymentService.processPayment(request);
        return HttpResponse.ok(response);
    }

    @Get("/{transactionId}")
    @Operation(
            summary = "Get payment status",
            description = "Retrieve the status of a payment by transaction ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Payment found",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PaymentResponse.class)
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Payment not found"
    )
    public HttpResponse<PaymentResponse> getPaymentStatus(
            @Parameter(description = "Transaction ID of the payment")
            @PathVariable String transactionId
    ) {
        PaymentResponse response = paymentService.getPaymentStatus(transactionId);
        return HttpResponse.ok(response);
    }
}

