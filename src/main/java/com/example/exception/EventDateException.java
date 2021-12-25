package com.example.exception;

public class EventDateException extends RuntimeException{

    public EventDateException() {
        super("The beginning of an event cannot be later than it's end");
    }
}
