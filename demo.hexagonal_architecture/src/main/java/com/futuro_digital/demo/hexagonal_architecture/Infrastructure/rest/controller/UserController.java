package com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.controller;

import com.futuro_digital.demo.hexagonal_architecture.Application.ports.in.*;
import com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.controller.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST paara "Request HTTP"
 *  ( solo delega las interfaces de entrada "UseCase" a los Endpoints )
 *  ( usa "Response" y "Request" como DTO )
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/api/v2/user")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    private final FindUserUseCase findUserUseCase;

    private final ListUsersUseCase listUsersUseCase;

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> all(){
        log.info("Ejecutando Endpoint /api/v2/user/all !");
        return ResponseEntity.ok(listUsersUseCase.getListOfUsers());
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id){
        log.info("Ejecutando Endpoint /api/v2/user/find/id/"+id+" !");
        return ResponseEntity.ok(findUserUseCase.findUser(id));
    }

    @GetMapping("/find/email/{email}")
    public ResponseEntity<UserResponse> findByEmail(@PathVariable String email){
        log.info("Ejecutando Endpoint /api/v2/user/find/email/"+email+" !");
        return ResponseEntity.ok(findUserUseCase.findUser(email));
    }

    @PostMapping("/save")
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest request){
        log.info("Ejecutando Endpoint /api/v2/user/save !");
        return ResponseEntity.ok(createUserUseCase.createUser(request));
    }
}
