package com.futuro_digital.demo.Ecommerce.Service;

import com.futuro_digital.demo.Ecommerce.DTO.ProductoDTO;
import com.futuro_digital.demo.Ecommerce.Entity.Producto;

import java.util.List;

public interface ProductoService {

    /**
     * Productos
     *
     */
    List<Producto> getListOfProductos();

    Producto findProductoById(Long id);

    Producto saveProducto(ProductoDTO productoDTO);

    void deleteProducto(Long id);

    Producto editProducto(ProductoDTO dto, Long id);


}
