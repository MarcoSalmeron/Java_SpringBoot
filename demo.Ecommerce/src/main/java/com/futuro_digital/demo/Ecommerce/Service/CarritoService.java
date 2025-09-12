package com.futuro_digital.demo.Ecommerce.Service;

import com.futuro_digital.demo.Ecommerce.Entity.Carrito;
import com.futuro_digital.demo.Ecommerce.Entity.DetalleCarrito;
import com.futuro_digital.demo.Ecommerce.Entity.Producto;

import java.util.List;

public interface CarritoService {

    // Obtener el carrito de un usuario (crea uno si no existe)
    Carrito obtenerCarritoPorUsuario(Long idUsuario);

    // Guardar o actualizar un carrito
    Carrito guardarCarrito(Carrito carrito);

    // Agregar un producto al carrito
    DetalleCarrito agregarProductoAlCarrito(Carrito carrito, Producto producto, int cantidad);

    // Eliminar un producto del carrito
    void eliminarProductoDelCarrito(Carrito carrito, Long idProducto);

    // Vaciar todos los productos del carrito
    void vaciarCarrito(Carrito carrito);

    // Obtener todos los detalles (productos) de un carrito
    List<DetalleCarrito> obtenerDetallesDelCarrito(Carrito carrito);

    // Eliminar cantidad del carrito
    boolean eliminarCantidadProducto(Carrito carrito, Long productoId, int cantidad);
}

