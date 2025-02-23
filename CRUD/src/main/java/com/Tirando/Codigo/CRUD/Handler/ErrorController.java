package com.Tirando.Codigo.CRUD.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

//Capturar Errores dentro del Controlador//
@ControllerAdvice
public class ErrorController {

    //Error si no hay Parametros//
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> handlerNoResourceFoundException(NoResourceFoundException e){
        return new ResponseEntity<>("Error, no hay parametros: "+e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //Error tipo de Dato Distinto//
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        return new ResponseEntity<>("Error, tipo de Dato diferente: "+e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //Error en caso de no encontrar ID//
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handlerNullPointerException(NullPointerException e){
        return new ResponseEntity<>("Error valor Null: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
