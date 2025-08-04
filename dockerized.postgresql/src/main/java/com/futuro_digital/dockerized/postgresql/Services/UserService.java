package com.futuro_digital.dockerized.postgresql.Services;

import com.futuro_digital.dockerized.postgresql.DTO.UserDTO;
import com.futuro_digital.dockerized.postgresql.Models.User;
import com.futuro_digital.dockerized.postgresql.Repositories.User_Repo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService implements UserService_Interface {

    @Autowired
    private final User_Repo userRepo;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    @Transactional
    public User saveUser(UserDTO user) {
        var usuario = User.builder()
                .name(user.name())
                .last_name(user.last_name())
                .phone(user.phone())
                .build();
        userRepo.save(usuario);
        return usuario;
    }

    @Override
    @Transactional
    public String deleteUser(Long id) {
        userRepo.deleteById(id);
        return "Usuario Eliminado!";
    }

    @Override
    @Transactional(readOnly = true)
    public User findUser(Long id) {
        return userRepo
                .findById(id)
                .orElseThrow(()-> new NoSuchElementException("Usuario No Encontrado! ID -> "+ id));
    }
}
