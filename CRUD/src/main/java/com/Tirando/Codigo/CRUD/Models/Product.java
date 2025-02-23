package com.Tirando.Codigo.CRUD.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//Entidad en B.D//
@Entity
@Data
public class Product {

    //Atributos//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private Double precio;
}
