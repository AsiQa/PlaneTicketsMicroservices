package com.raf.flight.service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerErrorHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException exception) {
        //Create error details object based on exception fields
        com.raf.flight.service.exception.ErrorDetails errorDetails = new com.raf.flight.service.exception.ErrorDetails(exception.getErrorCode(), exception.getMessage(), Instant.now());
        //Return error details and map http status from exception
        return new ResponseEntity<>(errorDetails, exception.getHttpStatus());
    }
}