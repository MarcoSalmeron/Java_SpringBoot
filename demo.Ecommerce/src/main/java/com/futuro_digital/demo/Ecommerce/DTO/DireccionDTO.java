package com.futuro_digital.demo.Ecommerce.DTO;

public record DireccionDTO(
        Long id,
        String calle,
        String codigoPostal,
        String ciudad,
        UsuarioDTO usuario
) {
}
