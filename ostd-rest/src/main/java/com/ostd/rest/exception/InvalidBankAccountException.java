package com.ostd.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidBankAccountException extends RuntimeException {

    public InvalidBankAccountException() {
        super();
    }
    public InvalidBankAccountException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidBankAccountException(String message) {
        super(message);
    }
    public InvalidBankAccountException(Throwable cause) {
        super(cause);
    }
}
