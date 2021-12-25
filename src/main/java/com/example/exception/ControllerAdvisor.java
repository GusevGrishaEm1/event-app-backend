package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(new LinkedHashMap<>().put("message", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UniqueLoginException.class)
    public ResponseEntity<Object> handleUniqueLoginException(UniqueLoginException ex) {
        return new ResponseEntity<>(new LinkedHashMap<>().put("message", ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EventDateException.class)
    public ResponseEntity<Object> handleEventDateException(EventDateException ex) {
        return new ResponseEntity<>(new LinkedHashMap<>().put("message", ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserAccessException.class)
    public ResponseEntity<Object> handleUserAccessException(UserAccessException ex) {
        return new ResponseEntity<>(new LinkedHashMap<>().put("message", ex.getMessage()), HttpStatus.LOCKED);
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<Object> handleEventNotFoundException(EventNotFoundException ex) {
        return new ResponseEntity<>(new LinkedHashMap<>().put("message", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExpirationTokenException.class)
    public ResponseEntity<Object> handleExpirationTokenException(ExpirationTokenException ex) {
        return new ResponseEntity<>(new LinkedHashMap<>().put("message", ex.getMessage()), HttpStatus.FORBIDDEN);
    }
}
