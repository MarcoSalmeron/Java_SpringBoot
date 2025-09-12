package com.futuro_digital.demo.Ecommerce.Repository;

import com.futuro_digital.demo.Ecommerce.Entity.DetalleCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetallesCarritoRepository extends JpaRepository<DetalleCarrito,Long> {

    Optional<DetalleCarrito> findByCarritoIdAndProductoId(Long idCarrito, Long idProducto);
    void deleteByCarritoIdAndProductoId(Long idCarrito, Long idProducto);
    void deleteByCarritoId(Long idCarrito);
    List<DetalleCarrito> findByCarritoId(Long idCarrito);
}
