package com.kendev.presentation.exception;


import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {Exception.class, ExceptionHandler.class})
public class GlobalExceptionHandler implements ExceptionHandler<Exception, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                exception.getMessage(),
                exception instanceof IllegalArgumentException ? 400 : 500
        );
        return HttpResponse.serverError(errorResponse);
    }
}
