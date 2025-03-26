package Tirando.Codigo.SpringSecurity.DTOs;

import lombok.Builder;
import lombok.Data;

//Encapsular Login//
@Data
@Builder
public class LoginDTO {

    private String username;

    private String password;
}
