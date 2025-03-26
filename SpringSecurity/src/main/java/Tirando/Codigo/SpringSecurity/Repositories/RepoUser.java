package Tirando.Codigo.SpringSecurity.Repositories;

import Tirando.Codigo.SpringSecurity.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//repo con acceso a datos
@Repository
public interface RepoUser extends JpaRepository<User,Long> {

    //buscar por usuario//
    public Optional<User> findByUsername(String username);
}
