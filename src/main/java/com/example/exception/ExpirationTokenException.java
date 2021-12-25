package com.example.exception;

public class ExpirationTokenException extends RuntimeException{
    public ExpirationTokenException() {
        super("The token expired");
    }
}
