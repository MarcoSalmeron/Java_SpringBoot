package Tirando.Codigo.QueryMethod.DTOs;

import jakarta.persistence.Column;
import lombok.Data;

//Encapsular Datos
@Data
public class Person_EmployeeDTO {

    //Atributos Persona//
    private String first_name;

    private String last_name;

    private Long number;

    private String address;

    private String email;

    //Atributos Empleado//
    private String Role;

    private String User;

    private String Password;

    private Double Salary;
}
