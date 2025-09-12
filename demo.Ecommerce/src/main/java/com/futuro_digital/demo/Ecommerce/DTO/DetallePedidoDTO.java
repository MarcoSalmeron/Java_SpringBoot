package com.futuro_digital.demo.Ecommerce.DTO;

public record DetallePedidoDTO(
        Long idDetallePedido,
        PedidoDTO pedido,
        ProductoDTO producto,
        Integer cantidad,
        Double precio_unitario
) {}
