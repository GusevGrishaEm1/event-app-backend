package com.example.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerAdvisor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdvisor.class);

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND.name());
        LOGGER.error("Exception: {}, {}", errorMessage.getMessage(), errorMessage.getHttpStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UniqueLoginException.class)
    public @ResponseBody ResponseEntity<ErrorMessage> handleUniqueLoginException(UniqueLoginException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.CONFLICT.name());
        LOGGER.error("Exception: {}, {}", errorMessage.getMessage(), errorMessage.getHttpStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({EventDateException.class})
    public ResponseEntity<ErrorMessage> handleEventDateException(EventDateException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.CONFLICT.name());
        LOGGER.error("Exception: {}, {}", errorMessage.getMessage(), errorMessage.getHttpStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserAccessException.class)
    public ResponseEntity<ErrorMessage> handleUserAccessException(UserAccessException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.LOCKED.name());
        LOGGER.error("Exception: {}, {}", errorMessage.getMessage(), errorMessage.getHttpStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.LOCKED);
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEventNotFoundException(EventNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND.name());
        LOGGER.error("Exception: {}, {}", errorMessage.getMessage(), errorMessage.getHttpStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
