package com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.controller.dto;

/**
 * Respuestas al usuario
 *  ( solo para la vista )
 * @param name
 * @param age
 * @param email
 */
public record UserResponse(
        String name,
        Integer age,
        String email
) { }
