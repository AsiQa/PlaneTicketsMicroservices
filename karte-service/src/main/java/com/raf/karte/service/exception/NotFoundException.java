package com.raf.karte.service.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends com.raf.karte.service.exception.CustomException {

    public NotFoundException(String message) {
        super(message, com.raf.karte.service.exception.ErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
