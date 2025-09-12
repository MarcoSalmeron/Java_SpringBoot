package com.futuro_digital.demo.Ecommerce.Service;

import com.futuro_digital.demo.Ecommerce.Entity.Carrito;
import com.futuro_digital.demo.Ecommerce.Entity.DetalleCarrito;
import com.futuro_digital.demo.Ecommerce.Entity.Producto;
import com.futuro_digital.demo.Ecommerce.Repository.CarritoRepository;
import com.futuro_digital.demo.Ecommerce.Repository.DetallesCarritoRepository;
import com.futuro_digital.demo.Ecommerce.Repository.ProductoRepository;
import com.futuro_digital.demo.Ecommerce.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class CarritoServiceImpl implements CarritoService {

    private final CarritoRepository carritoRepository;
    private final DetallesCarritoRepository detalleCarritoRepository;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public CarritoServiceImpl(CarritoRepository carritoRepository,
                              DetallesCarritoRepository detalleCarritoRepository,
                              ProductoRepository productoRepository,
                              UsuarioRepository usuarioRepository) {
        this.carritoRepository = carritoRepository;
        this.detalleCarritoRepository = detalleCarritoRepository;
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public Carrito obtenerCarritoPorUsuario(Long idUsuario) {
        return carritoRepository.findByUsuarioId(idUsuario)
                .orElseGet(() -> {
                    var usuario = usuarioRepository.findById(idUsuario)
                            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
                    Carrito nuevoCarrito = new Carrito();
                    nuevoCarrito.setUsuario(usuario);
                    nuevoCarrito.setFechaCreacion(LocalDate.now());
                    return carritoRepository.save(nuevoCarrito);
                });
    }

    @Override
    @Transactional
    public Carrito guardarCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    @Transactional
    public DetalleCarrito agregarProductoAlCarrito(Carrito carrito, Producto producto, int cantidad) {
        DetalleCarrito existente = detalleCarritoRepository
                .findByCarritoIdAndProductoId(carrito.getId(), producto.getId())
                .orElse(null);

        if (existente != null) {
            existente.setCantidad(existente.getCantidad() + cantidad);
            return detalleCarritoRepository.save(existente);
        } else {
            DetalleCarrito detalle = new DetalleCarrito();
            detalle.setCarrito(carrito);
            detalle.setProducto(producto);
            detalle.setCantidad(cantidad);
            return detalleCarritoRepository.save(detalle);
        }
    }

    @Override
    @Transactional
    public void eliminarProductoDelCarrito(Carrito carrito, Long idProducto) {
        detalleCarritoRepository.deleteByCarritoIdAndProductoId(carrito.getId(), idProducto);
    }

    @Override
    @Transactional
    public void vaciarCarrito(Carrito carrito) {
        detalleCarritoRepository.deleteByCarritoId(carrito.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetalleCarrito> obtenerDetallesDelCarrito(Carrito carrito) {
        return detalleCarritoRepository.findByCarritoId(carrito.getId());
    }

    @Override
    @Transactional
    public boolean eliminarCantidadProducto(Carrito carrito, Long productoId, int cantidad) {
        DetalleCarrito detalle = detalleCarritoRepository
                .findByCarritoIdAndProductoId(carrito.getId(), productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado en carrito"));

        if (cantidad >= detalle.getCantidad()) {
            detalleCarritoRepository.delete(detalle);
            return true; // eliminado completamente
        } else {
            detalle.setCantidad(detalle.getCantidad() - cantidad);
            detalleCarritoRepository.save(detalle);
            return false; // solo se actualizó cantidad
        }
    }
}