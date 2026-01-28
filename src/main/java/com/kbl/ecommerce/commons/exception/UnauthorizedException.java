package com.kbl.ecommerce.commons.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ApiException {

    public UnauthorizedException() {
        super("Unauthorized access", HttpStatus.UNAUTHORIZED);
    }
}

