package com.futuro_digital.dockerized.postgresql.GlobalExceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
public class ExceptionsHandler {

    // Error si no encuentra usuarios en BBDD
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElementException(NoSuchElementException ex){
        log.info("Ejecutando Error Handler No Such Element!");
        return new ResponseEntity<>("Problema = "+ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Error si no encuentra parametros en la solicitud http
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> missingServletRequestParameterException(MissingServletRequestParameterException ex){
        log.info("Ejecutando Error Handler Missing Request Param!");
        return new ResponseEntity<>("Falta Parametro Requerido! = "+ex.getParameterName(), HttpStatus.BAD_REQUEST);
    }

    // Error para tipos de dato incorrectos
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        log.info("Ejecutando Error Handler Argument Type Mismatch!");
        return new ResponseEntity<>("Tipo de Dato Incorrecto! = "+ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
