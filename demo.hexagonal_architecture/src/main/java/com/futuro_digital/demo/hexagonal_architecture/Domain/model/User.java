package com.futuro_digital.demo.hexagonal_architecture.Domain.model;

/**
 * Modelo de Dominio en el Negocio
 * ( Limpio de Frameworks y/o Librerías )
 * ( Sin lógica adicional )
 *
 * @param name
 * @param age
 * @param email
 */
public record User(

         String name,

         Integer age,

         String email
) { }

