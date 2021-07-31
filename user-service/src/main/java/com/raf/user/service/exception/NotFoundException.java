package com.raf.user.service.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends com.raf.user.service.exception.CustomException {

    public NotFoundException(String message) {
        super(message, com.raf.user.service.exception.ErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
