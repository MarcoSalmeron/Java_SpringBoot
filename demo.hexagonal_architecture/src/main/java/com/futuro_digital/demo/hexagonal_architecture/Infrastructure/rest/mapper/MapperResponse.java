package com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.mapper;

import com.futuro_digital.demo.hexagonal_architecture.Domain.model.User;
import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.controller.dto.UserRequest;
import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.controller.dto.UserResponse;

import java.util.List;

/**
 * Utilidades para Parsear el Modelo de Dominio a "Response"
 * Guarda el "Request" como un modelo de dominio
 */
public class MapperResponse {

    public static UserResponse toResponse(User user){
        return new UserResponse(user.name(), user.age(), user.email());
    }

    public static User toDomain(UserRequest request){
        return new User(request.name(), request.age(), request.email());
    }

    public static List<UserResponse> listMapperToResponse(List<User> users){
        return users.parallelStream().map(MapperResponse::toResponse).toList();
    }
}
