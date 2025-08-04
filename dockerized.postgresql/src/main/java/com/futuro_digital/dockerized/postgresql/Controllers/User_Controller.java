package com.futuro_digital.dockerized.postgresql.Controllers;

import com.futuro_digital.dockerized.postgresql.DTO.UserDTO;
import com.futuro_digital.dockerized.postgresql.Models.User;
import com.futuro_digital.dockerized.postgresql.Services.UserService_Interface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
public class User_Controller {

    @Autowired
    private final UserService_Interface userService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> findAllUsers(){
        log.info("Ejecutando Endpoint Find All Users");
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(path = "/find/{id}")
    public ResponseEntity<User> findUser(@PathVariable Long id){
        log.info("Ejecutando Endpoint Find User By ID");
        return ResponseEntity.ok(userService.findUser(id));
    }

    @PutMapping(path = "/create")
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        log.info("Ejecutando Endpoint Create User");
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        log.info("Ejecutando Endpoint Delete User By ID");
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
