package com.futuro_digital.demo.hexagonal_architecture.Application.ports.out;

import com.futuro_digital.demo.hexagonal_architecture.Domain.model.User;

import java.util.List;

/**
 * Interfáz de Salida
 * ( Un "Adapter" a Base de Datos debe Implementarlo )
 * ( Usa solo el Modelo del Dominio de Negocio )
 */
public interface UserRepositoryOutPort {

    User createUser(User user);

    User findUser(Long id);

    User findUser(String email);

    List<User> getListOfUsers();
}
