package com.dawissem.biat.Exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadCredentialExecption.class)
    public ResponseEntity<?> handleResourceNotFoundException(BadCredentialExecption ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);}

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> handleResourceNotFoundException(AlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);}


    @ExceptionHandler( UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException( UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);}

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String message = "Data integrity violation  " ;
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
