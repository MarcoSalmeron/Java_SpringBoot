package Tirando.Codigo.SpringSecurity.Controllers;

import Tirando.Codigo.SpringSecurity.DTOs.AuthResponse;
import Tirando.Codigo.SpringSecurity.DTOs.LoginDTO;
import Tirando.Codigo.SpringSecurity.DTOs.RegisterDTO;
import Tirando.Codigo.SpringSecurity.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    //Rutas Publicas//

    @Autowired
    private AuthService authService;

    //Pedir Login//
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDTO login){
        return ResponseEntity.ok(authService.getLogin(login));
    }

    //Pedir Register
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterDTO register){
        return ResponseEntity.ok(authService.getRegister(register));
    }
}
