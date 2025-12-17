package com.futuro_digital.demo.hexagonal_architecture.Application.ports.in;

import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.controller.dto.UserResponse;

public interface FindUserUseCase {

    UserResponse findUser(Long id);

    UserResponse findUser(String email);
}
