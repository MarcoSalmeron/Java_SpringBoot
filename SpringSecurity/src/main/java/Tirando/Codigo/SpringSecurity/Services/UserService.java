package Tirando.Codigo.SpringSecurity.Services;

import Tirando.Codigo.SpringSecurity.Models.User;
import Tirando.Codigo.SpringSecurity.Repositories.RepoUser;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private RepoUser repoUser;


    //CRUD Protegido//

    public List<User> getAllUsers(){
        return  repoUser.findAll();
    }

    public User findUser(Long ID){
        return repoUser
                .findById(ID)
                .orElseThrow(()->new EntityNotFoundException("ID Inexistente: "+ID));
    }

    public User editUser(User user){
        return repoUser.save(user);
    }

    public String deleteUser(Long ID){
        repoUser.deleteById(ID);
        return "Usuario Eliminado";
    }
}
