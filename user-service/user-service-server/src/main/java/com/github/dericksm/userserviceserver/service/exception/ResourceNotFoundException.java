package com.github.dericksm.userserviceserver.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final String MSG_USER_NOT_FOUND = "User with id: %d wasn't found";

    public ResourceNotFoundException(Integer id) {
        super(String.format(MSG_USER_NOT_FOUND, id));
    }
}