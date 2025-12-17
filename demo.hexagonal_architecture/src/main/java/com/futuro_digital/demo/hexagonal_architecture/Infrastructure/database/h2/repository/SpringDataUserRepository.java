package com.futuro_digital.demo.hexagonal_architecture.Infrastructure.database.h2.repository;

import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.database.h2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interfáz que interactua con la base de datos H2
 *  ( dependencia del "Adapter" )
 */
public interface SpringDataUserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByEmailIgnoreCase(String email);
}
