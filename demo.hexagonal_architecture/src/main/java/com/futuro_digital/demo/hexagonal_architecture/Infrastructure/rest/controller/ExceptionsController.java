package com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controlador REST para Excepciones Explícitas Globales
 */
@Slf4j
@RestControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundException(EntityNotFoundException ex){
        log.warn("Ejecutando Error Handler: "+ex.getClass());
        return new ResponseEntity<>("{ Exception ( entity not found ) } -> "+ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> runtimeException(RuntimeException ex){
        log.warn("Ejecutando Error Handler: "+ex.getClass());
        return new ResponseEntity<>(" { Exception ( Runtime ) } -> "+ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
