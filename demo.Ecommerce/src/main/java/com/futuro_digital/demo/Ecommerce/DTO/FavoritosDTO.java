package com.futuro_digital.demo.Ecommerce.DTO;

import java.time.LocalDate;

public record FavoritosDTO(
    Long id,
    UsuarioDTO usuario,
    ProductoDTO producto,
    LocalDate fecha
) {

}
