package com.ron.findmylol_b.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(InvalidPayloadException.class)
    public ResponseEntity<?> InvalidPayloadException(InvalidPayloadException invalidPayloadException){
        return ResponseEntity.status(400).body(invalidPayloadException);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> CustomException(CustomException customException){
        return ResponseEntity.status(400).body(customException);
    }


    
    
    
}
