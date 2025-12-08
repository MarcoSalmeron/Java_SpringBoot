package com.futuro_digital.demo.hexagonal_architecture.Application.ports.in;

import com.futuro_digital.demo.hexagonal_architecture.Application.dto.UserDTO;

public interface CreateUserUseCase {

    UserDTO createUser(UserDTO dto);
}
