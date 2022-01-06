package com.tqi.SCred_TQI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AddressNotFoundException extends Exception{

    public AddressNotFoundException(String message) {
        super(message);
    }
}
