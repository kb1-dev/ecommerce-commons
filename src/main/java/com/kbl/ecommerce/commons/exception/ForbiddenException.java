package com.kbl.ecommerce.commons.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends ApiException {

    public ForbiddenException() {
        super("Access denied", HttpStatus.FORBIDDEN);
    }
}
