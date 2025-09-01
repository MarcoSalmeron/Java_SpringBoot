package com.futuro_digital.demo.Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "FAVORITOS")
public class Favoritos implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FAVORITO")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(name = "favoritos_ibfk_1"))
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Producto", referencedColumnName = "ID_Producto",
            foreignKey = @ForeignKey(name = "favoritos_ibfk_2"))
    private Producto producto;

    @Column(name = "fecha")
    private LocalDate fecha;
}
