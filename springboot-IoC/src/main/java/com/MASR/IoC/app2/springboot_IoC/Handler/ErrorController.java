package com.MASR.IoC.app2.springboot_IoC.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

//Capturar Excepciones dentro del Controlador//
@ControllerAdvice
public class ErrorController {

    //Error en caso no encontrar PathVariable en url//
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> handlerNoResourceFoundException(NoResourceFoundException e){
        return new ResponseEntity<>("Error, no hay parametros : "+e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //Error en caso de no encontrar ID//
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handlerNullPointerException(NullPointerException e){
        return new ResponseEntity<>("Error, no existe ID : "+e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Error en caso de tipo de dato distinto //
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        String errorMessage = "Error, el tipo de dato proporcionado no es válido: " + e.getValue();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    // Error en caso de entidad no encontrada //
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>("Error, entidad no encontrada: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
