package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND.name());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UniqueLoginException.class)
    public ResponseEntity<ErrorMessage> handleUniqueLoginException(UniqueLoginException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.CONFLICT.name());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EventDateException.class)
    public ResponseEntity<ErrorMessage> handleEventDateException(EventDateException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.CONFLICT.name());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserAccessException.class)
    public ResponseEntity<ErrorMessage> handleUserAccessException(UserAccessException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.LOCKED.name());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.LOCKED);
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEventNotFoundException(EventNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND.name());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExpirationTokenException.class)
    public ResponseEntity<ErrorMessage> handleExpirationTokenException(ExpirationTokenException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.FORBIDDEN.name());
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.FORBIDDEN);
    }
}
