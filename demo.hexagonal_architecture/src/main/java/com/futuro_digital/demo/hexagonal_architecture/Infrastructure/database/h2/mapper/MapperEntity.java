package com.futuro_digital.demo.hexagonal_architecture.Infrastructure.database.h2.mapper;

import com.futuro_digital.demo.hexagonal_architecture.Domain.model.User;
import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.database.h2.entity.UserEntity;

import java.util.List;

/**
 * Utilidades para Parsear el Modelo de Dominio a "Entity" y viceversa
 */
public class MapperEntity {

    public static UserEntity toEntity(User user){
        return UserEntity.builder()
                .name(user.name())
                .age(user.age())
                .email(user.email())
                .build();
    }

    public static User toDomain(UserEntity entity){
        return new User(entity.getName(), entity.getAge(), entity.getEmail());
    }

    public static List<User> listMapperToDomain(List<UserEntity> entities){
        return entities.parallelStream().map(MapperEntity::toDomain).toList();
    }
}
