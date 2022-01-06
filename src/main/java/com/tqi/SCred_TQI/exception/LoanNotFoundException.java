package com.tqi.SCred_TQI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoanNotFoundException extends Exception{

    public LoanNotFoundException(String message) {
        super(message);
    }
}
