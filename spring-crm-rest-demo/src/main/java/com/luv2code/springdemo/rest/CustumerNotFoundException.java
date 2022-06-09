package com.luv2code.springdemo.rest;

public class CustumerNotFoundException extends RuntimeException{
    public CustumerNotFoundException() {
    }

    public CustumerNotFoundException(String message) {
        super(message);
    }

    public CustumerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustumerNotFoundException(Throwable cause) {
        super(cause);
    }

    public CustumerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
