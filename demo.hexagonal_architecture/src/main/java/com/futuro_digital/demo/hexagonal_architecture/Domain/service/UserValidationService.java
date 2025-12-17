package com.futuro_digital.demo.hexagonal_architecture.Domain.service;

import com.futuro_digital.demo.hexagonal_architecture.Domain.model.User;

/**
 * Servicio del Dominio
 * ( Limpio sin Frameworks y/o Librerías )
 * ( Sin lógica adicional solo validación )
 */
public class UserValidationService {

    // Validar campos nulos
    public static boolean isUserValid(User user){
        return user.name() != null && user.age() != null && user.email() != null;
    }
}
