package com.futuro_digital.dockerized.postgresql.Services;

import com.futuro_digital.dockerized.postgresql.DTO.UserDTO;
import com.futuro_digital.dockerized.postgresql.Models.User;

import java.util.List;

public interface UserService_Interface {

    List<User> getAllUsers();

    User saveUser(UserDTO user);

    String deleteUser(Long id);

    User findUser(Long id);
}
