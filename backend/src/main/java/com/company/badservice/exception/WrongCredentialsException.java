package com.company.badservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class WrongCredentialsException extends RuntimeException {
    public WrongCredentialsException(String message){
        super(message);
    }
}
