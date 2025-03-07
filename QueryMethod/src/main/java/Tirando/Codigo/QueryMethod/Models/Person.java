package Tirando.Codigo.QueryMethod.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entidad en B.D//
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Basic
    private String first_name;

    private String last_name;

    @Column(unique = true)
    private Long number;

    private String address;

    @Column(unique = true)
    private String email;

    //Relacionar Persona a Empleado//
    @OneToOne(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Employee employee;
}
