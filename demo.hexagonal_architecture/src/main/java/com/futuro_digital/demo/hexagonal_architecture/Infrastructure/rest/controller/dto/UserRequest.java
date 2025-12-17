package com.futuro_digital.demo.hexagonal_architecture.Infrastructure.rest.controller.dto;

import jakarta.validation.constraints.*;

/**
 * Solicitudes del Usuario:
 *  ( con validaciones )
 *  @param name
 *  @param age
 *  @param email
 */
public record UserRequest(
        @NotBlank(message = "Name cant be empty")
        String name,

        @NotNull(message = "Age cant be empty")
        @Min(value = 0, message = "Age must be positive")
        @Max(value = 78,message = "Age must be lower than 68 years old")
        Integer age,

        @NotBlank(message = "The email cant be empty")
        @Email(message = "invalid email")
        @Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",
                message = "The email must have the domain: gmail.com")
        String email
) { }
