package Tirando.Codigo.SpringSecurity.DTOs;

import lombok.Builder;
import lombok.Data;

//Encapsular Registro//
@Data
@Builder
public class RegisterDTO {

    private String username;

    private String password;

    private String first_name;

    private String last_name;

    private String email;

    private String country;
}
