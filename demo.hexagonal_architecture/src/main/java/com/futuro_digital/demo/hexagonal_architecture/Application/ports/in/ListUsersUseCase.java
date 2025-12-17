package com.futuro_digital.demo.hexagonal_architecture.Application.ports.in;

import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.controller.dto.UserResponse;

import java.util.List;

public interface ListUsersUseCase {

    List<UserResponse> getListOfUsers();
}
