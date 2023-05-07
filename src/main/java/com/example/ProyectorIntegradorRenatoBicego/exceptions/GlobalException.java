package com.example.ProyectorIntegradorRenatoBicego.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarBadRequestError(BadRequestException err){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
    }
}
