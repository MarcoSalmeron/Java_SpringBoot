package com.futuro_digital.demo.Ecommerce.Service;

import com.futuro_digital.demo.Ecommerce.DTO.ProductoDTO;
import com.futuro_digital.demo.Ecommerce.Entity.Producto;
import com.futuro_digital.demo.Ecommerce.Repository.CategoriaRepository;
import com.futuro_digital.demo.Ecommerce.Repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    @Autowired
    private final ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getListOfProductos() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findProductoById(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new IllegalStateException("Producto con ID : "+id+" no encontrado..."));
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findProductoByNombre(String nombre) {
        return productoRepository.findByNombre(nombre).orElseThrow(() -> new IllegalStateException("Producto con Nombre : "+nombre+" no encontrado..."));
    }

    @Override
    @Transactional
    public Producto saveProducto(ProductoDTO productoDTO) {
        var categoria = categoriaRepository.findById(productoDTO.categoria().id()).get();
        var producto = Producto.builder()
                .nombre(productoDTO.nombre())
                .marca(productoDTO.marca())
                .descripcion(productoDTO.descripcion())
                .cantidad(productoDTO.cantidad())
                .precio(productoDTO.precio())
                .porcentajeDescuento(productoDTO.porcentajeDescuento())
                .categoria(categoria)
                .url_imagen(productoDTO.url_imagen())
                .build();
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Producto editProducto(ProductoDTO dto, Long id) {
        var prodOpt = productoRepository.findById(id);

        if (id == null || prodOpt.isEmpty()) {
            throw new IllegalStateException("Producto no encontrado con ID: " + id);
        }

        var producto = prodOpt.get();

        // Actualizar los campos del producto con los valores del DTO
        producto.setNombre(dto.nombre());
        producto.setMarca(dto.marca());
        producto.setDescripcion(dto.descripcion());
        producto.setCantidad(dto.cantidad());
        producto.setPrecio(dto.precio());
        producto.setPorcentajeDescuento(dto.porcentajeDescuento());
        producto.setUrl_imagen(dto.url_imagen());

        // Buscar y asignar la categoría
        if (dto.categoria() != null && dto.categoria().id() != null) {
            var categoria = categoriaRepository.findById(dto.categoria().id()).get();
            producto.setCategoria(categoria);
        }

        return productoRepository.save(producto);
    }

}
