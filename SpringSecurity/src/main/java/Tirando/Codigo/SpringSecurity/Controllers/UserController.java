package Tirando.Codigo.SpringSecurity.Controllers;

import Tirando.Codigo.SpringSecurity.Models.User;
import Tirando.Codigo.SpringSecurity.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    //Rutas Protegidas//

    @Autowired
    private UserService userService;

    //Mostrar Todos//
    @GetMapping("/All")
    public ResponseEntity<List<User>> All(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    //Buscar//
    @PostMapping("/Find/{ID}")
    public ResponseEntity<User> Find(@PathVariable Long ID){
        return ResponseEntity.ok(userService.findUser(ID));
    }

    //Editar//
    @PutMapping("/Edit")
    public ResponseEntity<User> Edit(@RequestBody User user){
        return ResponseEntity.ok(userService.editUser(user));
    }

    //Borrar//
    @DeleteMapping("/Delete/{ID}")
    public ResponseEntity<String> Delete(@PathVariable Long ID){
        return ResponseEntity.ok(userService.deleteUser(ID));
    }


}
