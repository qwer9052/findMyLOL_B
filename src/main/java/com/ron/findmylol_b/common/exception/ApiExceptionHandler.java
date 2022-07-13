package com.ron.findmylol_b.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApiExceptionHandler {

//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<CommonFailResponseDto> HandleMemberNotExistException(NoSuchElementException noSuchElementException){
//        return ResponseEntity.status(400).body(new CommonFailResponseDto("1999", noSuchElementException.getMessage(), null));
//    }


    
    
    
}
