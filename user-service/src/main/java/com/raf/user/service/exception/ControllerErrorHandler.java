package com.raf.user.service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerErrorHandler {

    @ExceptionHandler(com.raf.user.service.exception.CustomException.class)
    public ResponseEntity<?> handleCustomException(com.raf.user.service.exception.CustomException exception) {
        //Create error details object based on exception fields
        com.raf.user.service.exception.ErrorDetails errorDetails = new com.raf.user.service.exception.ErrorDetails(exception.getErrorCode(), exception.getMessage(), Instant.now());
        //Return error details and map http status from exception
        return new ResponseEntity<>(errorDetails, exception.getHttpStatus());
    }
}