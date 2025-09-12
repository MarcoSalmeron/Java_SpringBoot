package com.futuro_digital.demo.Ecommerce.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "DIRECCIONES")
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIRECCION")
    private Long id;

    @NotEmpty
    @Column(name = "Calle", nullable = false)
    private String calle;

    @NotEmpty
    @Column(name = "Codigo_Postal", nullable = false)
    private String codigoPostal;

    @NotEmpty
    @Column(name = "Ciudad", nullable = false)
    private String ciudad;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(name = "direcciones_ibfk_1"))
    @JsonIgnore
    private Usuario usuario;


}
