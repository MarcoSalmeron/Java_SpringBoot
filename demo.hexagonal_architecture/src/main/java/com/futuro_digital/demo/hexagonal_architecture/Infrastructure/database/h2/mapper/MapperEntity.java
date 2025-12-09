package com.futuro_digital.demo.hexagonal_architecture.Infrastructure.database.h2.mapper;

import com.futuro_digital.demo.hexagonal_architecture.Domain.model.User;
import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.database.h2.entity.UserEntity;

import java.util.List;

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

    public static List<User> listMapper(List<UserEntity> entities){
        return entities.parallelStream().map(MapperEntity::toDomain).toList();
    }
}
