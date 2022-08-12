package com.github.dericksm.productserviceserver.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final String MSG_PRODUCT_INFO_NOT_FOUND = "Product with id: %s wasn't found";

    public ResourceNotFoundException(String id) {
        super(String.format(MSG_PRODUCT_INFO_NOT_FOUND, id));
    }
}