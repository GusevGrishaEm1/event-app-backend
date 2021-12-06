package com.example.exception;

public class UniqueLoginException extends RuntimeException {
    public UniqueLoginException(String message) {
        super(message);
    }
}
