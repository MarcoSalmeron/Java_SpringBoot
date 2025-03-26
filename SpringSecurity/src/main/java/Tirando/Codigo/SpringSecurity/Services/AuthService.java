package Tirando.Codigo.SpringSecurity.Services;


import Tirando.Codigo.SpringSecurity.DTOs.AuthResponse;
import Tirando.Codigo.SpringSecurity.DTOs.LoginDTO;
import Tirando.Codigo.SpringSecurity.DTOs.RegisterDTO;
import Tirando.Codigo.SpringSecurity.Models.Role;
import Tirando.Codigo.SpringSecurity.Models.User;
import Tirando.Codigo.SpringSecurity.Repositories.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JWTservice jwtService;

    @Autowired
    private RepoUser repoUser;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;


    //pedir Login//
    public AuthResponse getLogin(LoginDTO login){
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword()));
        User user = repoUser
                .findByUsername(login.getUsername())
                .orElseThrow(()->new UsernameNotFoundException("Usuario Inexistente"));

        String token = jwtService.getToken(user);

        return AuthResponse
                .builder()
                .token(token)
                .build();

    }

    //pedir registro//
    public AuthResponse getRegister(RegisterDTO register){

        //Instanciar y Guardar Entidad
        User user = User.builder()
                .username(register.getUsername())
                .password(passwordEncoder.encode(register.getPassword()))
                .first_name(register.getFirst_name())
                .last_name(register.getLast_name())
                .email(register.getEmail())
                .country(register.getCountry())
                .role(Role.USER)
                .build();
        repoUser.save(user);

        return AuthResponse
                .builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
