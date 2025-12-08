package com.futuro_digital.demo.hexagonal_architecture.Application.ports.in;

import com.futuro_digital.demo.hexagonal_architecture.Application.dto.UserDTO;

import java.util.List;

public interface ListUsersUseCase {

    List<UserDTO> getListOfUsers();
}
