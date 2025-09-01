package com.futuro_digital.demo.Ecommerce.DTO;

public record UsuarioDTO(
        Long idUsuario,
        String username,
        String password,
        String direccion,
        RoleDTO roleDTO
) {}