package FuturoDigital.Employees.Controllers;

import FuturoDigital.Employees.DTOs.AuthResponse;
import FuturoDigital.Employees.DTOs.LoginDTO;
import FuturoDigital.Employees.DTOs.Person_Employee;
import FuturoDigital.Employees.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthController {


    @Autowired
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody Person_Employee personEmployee){
        return ResponseEntity.ok(authService.getRegister(personEmployee));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(authService.getLogin(loginDTO));
    }
}
