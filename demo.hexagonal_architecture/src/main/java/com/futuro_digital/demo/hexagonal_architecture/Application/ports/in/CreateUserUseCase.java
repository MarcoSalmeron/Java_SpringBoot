package com.futuro_digital.demo.hexagonal_architecture.Application.ports.in;

import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.controller.dto.UserRequest;
import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.controller.dto.UserResponse;

public interface CreateUserUseCase {

    UserResponse createUser(UserRequest userRequest);
}
