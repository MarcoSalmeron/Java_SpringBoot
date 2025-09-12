package com.futuro_digital.demo.Ecommerce.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CARRITO")
public class Carrito implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Carrito")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuario usuario;

    @NotNull
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "precio_envio")
    private Double precioEnvio;

    @Column(name = "impuesto")
    private Double impuesto;

    @OneToMany(mappedBy = "carrito")
    private List<DetalleCarrito> detallesCarrito;

    @OneToMany(mappedBy = "carrito")
    private List<Pedido> pedidos;
}

