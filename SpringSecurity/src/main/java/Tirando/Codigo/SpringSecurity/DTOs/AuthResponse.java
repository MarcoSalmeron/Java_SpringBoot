package Tirando.Codigo.SpringSecurity.DTOs;

import lombok.Builder;
import lombok.Data;

//Encapsular Token//
@Data
@Builder
public class AuthResponse {

    private String token;
}
