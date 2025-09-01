package com.futuro_digital.demo.Ecommerce.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CATEGORIAS")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Categoria")
    private Long id;

    @NotEmpty
    @Column(name = "categoria",nullable = false)
    private String categoria;

    @NotEmpty
    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @NotEmpty
    @Column(name = "url_imagen", nullable = false, length = 350)
    private String url_imagen;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos;
}
