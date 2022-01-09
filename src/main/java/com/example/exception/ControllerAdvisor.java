package com.example.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdvisor.class);

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException ex) {
        LOGGER.error("Exception: {}", ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND.name());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UniqueLoginException.class)
    public ResponseEntity<ErrorMessage> handleUniqueLoginException(UniqueLoginException ex) {
        LOGGER.error("Exception: {}", ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.CONFLICT.name());
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EventDateException.class)
    public ResponseEntity<ErrorMessage> handleEventDateException(EventDateException ex) {
        LOGGER.error("Exception: {}", ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.CONFLICT.name());
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserAccessException.class)
    public ResponseEntity<ErrorMessage> handleUserAccessException(UserAccessException ex) {
        LOGGER.error("Exception: {}", ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.LOCKED.name());
        return new ResponseEntity<>(errorMessage, HttpStatus.LOCKED);
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEventNotFoundException(EventNotFoundException ex) {
        LOGGER.error("Exception: {}", ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND.name());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExpirationTokenException.class)
    public ResponseEntity<ErrorMessage> handleExpirationTokenException(ExpirationTokenException ex) {
        LOGGER.error("Exception: {}", ex.getMessage());
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.FORBIDDEN.name());
        return new ResponseEntity<>(errorMessage, HttpStatus.FORBIDDEN);
    }
}
