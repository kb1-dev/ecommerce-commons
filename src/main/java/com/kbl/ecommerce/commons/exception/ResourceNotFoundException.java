package com.kbl.ecommerce.commons.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {
    public ResourceNotFoundException(String resource, Object value) {
        super(resource + " not found with value: " + value, HttpStatus.NOT_FOUND);
    }
}
