package com.example.exception;

public class ErrorMessage {

    private final String message;
    private final String httpStatus;

    public ErrorMessage(String message, String httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public String getHttpStatus() {
        return httpStatus;
    }



    @Override
    public String toString() {
        return "ErrorMessage{" +
                "message='" + message + '\'' +
                ", httpStatus='" + httpStatus + '\'' +
                '}';
    }
}
