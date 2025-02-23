package com.Tirando.Codigo.CRUD.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//Entidad en B.D//
@Entity
@Data
public class Staff {

    //Atributos//
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;

    private String usuario;
    private String nombre;
    private int contra;
}
