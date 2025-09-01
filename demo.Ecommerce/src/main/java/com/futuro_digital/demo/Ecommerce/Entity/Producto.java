
package  com.futuro_digital.demo.Ecommerce.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PRODUCTOS")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Producto")
    private Long id;

    @NotEmpty
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotEmpty
    @Column(name = "marca", nullable = false, length = 100)
    private String marca;

    @NotEmpty
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @NotNull
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @NotNull
    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "pct_descuento")
    private Double porcentajeDescuento;

    @NotEmpty
    @Column(name = "url_imagen", nullable = false, length = 350)
    private String url_imagen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favoritos> favoritos;
}