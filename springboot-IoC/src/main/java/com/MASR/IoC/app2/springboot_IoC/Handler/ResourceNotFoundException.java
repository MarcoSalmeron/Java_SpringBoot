package com.MASR.IoC.app2.springboot_IoC.Handler;

//Metodo cuando se Retorne Null//
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
