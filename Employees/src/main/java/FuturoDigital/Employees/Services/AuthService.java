package FuturoDigital.Employees.Services;

import FuturoDigital.Employees.DTOs.AuthResponse;
import FuturoDigital.Employees.DTOs.LoginDTO;
import FuturoDigital.Employees.DTOs.Person_Employee;
import FuturoDigital.Employees.Models.Employees;
import FuturoDigital.Employees.Models.Person;
import FuturoDigital.Employees.Models.Role;
import FuturoDigital.Employees.Repositories.Repo_Employee;
import FuturoDigital.Employees.Repositories.Repo_Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final JWT_Service jwtService;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final Repo_Employee repoEmployee;

    @Autowired
    private final Repo_Person repoPerson;

    public AuthResponse getLogin(LoginDTO login){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword()));
        Employees employee = repoEmployee.findByUsername(login.getUsername());
        return AuthResponse.builder()
                .token(jwtService.getToken(employee))
                .build();
    }

    public AuthResponse getRegister(Person_Employee personEmployee){
        Person person = Person.builder()
                .name(personEmployee.getName())
                .last_name(personEmployee.getLast_name())
                .email(personEmployee.getEmail())
                .number(personEmployee.getNumber())
                .build();
        repoPerson.save(person);
        Employees employee = Employees.builder()
                .title(personEmployee.getTitle())
                .area(personEmployee.getArea())
                .salary(personEmployee.getSalary())
                .username(personEmployee.getUsername())
                .password(passwordEncoder.encode(personEmployee.getPassword()))
                .role(Role.USER)
                .person(person)
                .build();
        repoEmployee.save(employee);
        return AuthResponse.builder()
                .token(jwtService.getToken(employee))
                .build();
    }
}
