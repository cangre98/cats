package com.example.catApp.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<HashMap> handleApiException(ApiException ex) {
        HashMap map = new HashMap<>();
        map.put("message",ex.getMessage());
        return new ResponseEntity<>(map, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
