package com.futuro_digital.demo.Ecommerce.DTO;

import java.time.LocalDate;

public record PedidoDTO(
        Long idPedido,
        LocalDate fecha,
        Double precioEnvio,
        UsuarioDTO usuario
) {}
