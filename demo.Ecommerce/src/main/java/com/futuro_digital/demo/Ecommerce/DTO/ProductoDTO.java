package com.futuro_digital.demo.Ecommerce.DTO;

public record ProductoDTO(
        Long id,
        String nombre,
        String marca,
        String descripcion,
        Integer cantidad,
        Double precio,
        Double porcentajeDescuento,
        String url_imagen,
        CategoriaDTO categoria
) {}
