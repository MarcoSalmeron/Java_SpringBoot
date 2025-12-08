package com.futuro_digital.demo.hexagonal_architecture.Domain.service;

import com.futuro_digital.demo.hexagonal_architecture.Domain.model.User;

public class UserValidationService {

    public static boolean isUserValid(User user){
        return user.name() != null && user.age() != null && user.email() != null;
    }
}
