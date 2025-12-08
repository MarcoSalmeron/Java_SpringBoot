package com.futuro_digital.demo.hexagonal_architecture.Application.ports.out;

import com.futuro_digital.demo.hexagonal_architecture.Application.dto.UserDTO;
import com.futuro_digital.demo.hexagonal_architecture.Domain.model.User;

import java.util.List;

public interface UserRepositoryOutPort {

    User createUser(UserDTO dto);

    User findUser(Long id);

    User findUser(String email);

    List<User> getListOfUsers();
}
