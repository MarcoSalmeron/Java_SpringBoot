package com.Tirando.Codigo.demo.Archivos.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

//Capturar Excepiones con Controlador//
@ControllerAdvice
public class ErrorController {

    //Manejar Excepciones de Entrada o Salida "IO" //
    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handlerIOException(IOException e){
        return new ResponseEntity<>("Problema: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Manejar Excepciones si falta Parametros//
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handlerMissingServletRequestParameterException(MissingServletRequestParameterException e){
        return new ResponseEntity<>("No hay Parametro: "+e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
