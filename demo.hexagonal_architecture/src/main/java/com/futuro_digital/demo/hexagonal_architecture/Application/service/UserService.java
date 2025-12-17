package com.futuro_digital.demo.hexagonal_architecture.Application.service;

import com.futuro_digital.demo.hexagonal_architecture.Application.ports.in.CreateUserUseCase;
import com.futuro_digital.demo.hexagonal_architecture.Application.ports.in.FindUserUseCase;
import com.futuro_digital.demo.hexagonal_architecture.Application.ports.in.ListUsersUseCase;
import com.futuro_digital.demo.hexagonal_architecture.Application.ports.out.UserRepositoryOutPort;
import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.controller.dto.UserRequest;
import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.controller.dto.UserResponse;
import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.mapper.MapperResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Servicio en la Aplicación:
 *  ( los ports de entrada "UseCase" los implementa el port de salida "OutPort" )
 *  ( usa un "Response" para la vista )
 */
@Service
@RequiredArgsConstructor
public class UserService implements CreateUserUseCase, FindUserUseCase, ListUsersUseCase {

    private final UserRepositoryOutPort userRepositoryOutPort;

    @Override
    public UserResponse createUser(UserRequest request) {
        //( parsea a modelo de dominio y retorna un DTO "Response" )
        return MapperResponse.toResponse(userRepositoryOutPort.createUser(MapperResponse.toDomain(request)));
    }

    @Override
    public UserResponse findUser(Long id) {
        return MapperResponse.toResponse(userRepositoryOutPort.findUser(id));
    }

    @Override
    public UserResponse findUser(String email) {
        return MapperResponse.toResponse(userRepositoryOutPort.findUser(email));
    }

    @Override
    public List<UserResponse> getListOfUsers() {
        return MapperResponse.listMapperToResponse(userRepositoryOutPort.getListOfUsers());
    }
}
