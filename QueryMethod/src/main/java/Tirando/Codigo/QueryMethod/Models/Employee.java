package Tirando.Codigo.QueryMethod.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entidad en B.D//
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Basic
    private String role;

    @Column(unique = true)
    private String user;

    @Column(unique = true)
    @JsonIgnore
    private String password;

    private Double salary;

    //Cada Entidad Empleado tiene Entidad Persona//
    @OneToOne
    @JoinColumn(name = "Person_ID", referencedColumnName = "ID")
    @JsonIgnore
    private Person person;

}
