package com.futuro_digital.demo.Ecommerce.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "DETALLES_CARRITO")
public class DetalleCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Detalle_Carrito")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_Carrito", nullable = false)
    private Carrito carrito;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_Producto", nullable = false)
    private Producto producto;

    @NotNull
    @Column(name = "cantidad")
    private Integer cantidad;
}

