package com.futuro_digital.demo.hexagonal_architecture.Infrastructure.database.h2.adapter;

import com.futuro_digital.demo.hexagonal_architecture.Application.ports.out.UserRepositoryOutPort;
import com.futuro_digital.demo.hexagonal_architecture.Domain.model.User;
import com.futuro_digital.demo.hexagonal_architecture.Domain.service.UserValidationService;
import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.database.h2.mapper.MapperEntity;
import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.database.h2.repository.SpringDataUserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Adaptador a Base de Datos H2:
 *  ( implementa la interfáz de salida "OutPort" )
 *  ( usa el modelo de dominio )
 *  ( dependencias: repositorio a base de datos "H2" )
 */
@Repository
@RequiredArgsConstructor
public class UserJpaRepositoryAdapter implements UserRepositoryOutPort {

    private final SpringDataUserRepository springDataUserRepository;

    @Override
    @Transactional
    public User createUser(User user) {
        if(!UserValidationService.isUserValid(user)) throw new RuntimeException("-{ User invalid!");
        // ( parsea a "Entity" y retorna el Modelo de Dominio )
        return MapperEntity.toDomain(springDataUserRepository.save(MapperEntity.toEntity(user)));
    }

    @Override
    @Transactional(readOnly = true)
    public User findUser(Long id) {
        return MapperEntity.toDomain( springDataUserRepository
                .findById(id)
                .orElseThrow(()->new EntityNotFoundException("-{ User with -Id : "+id+" not found...")));
    }

    @Override
    @Transactional(readOnly = true)
    public User findUser(String email) {
        return MapperEntity.toDomain( springDataUserRepository
                .findByEmailIgnoreCase(email.strip())
                .orElseThrow(()->new EntityNotFoundException("-{ User with -Email : "+email+" not found...")));
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getListOfUsers() {
        return MapperEntity.listMapperToDomain(springDataUserRepository.findAll());
    }
}
