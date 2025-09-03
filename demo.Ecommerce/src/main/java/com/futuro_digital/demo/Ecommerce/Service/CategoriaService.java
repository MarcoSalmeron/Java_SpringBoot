package com.futuro_digital.demo.Ecommerce.Service;

import com.futuro_digital.demo.Ecommerce.DTO.CategoriaDTO;
import com.futuro_digital.demo.Ecommerce.Entity.Categoria;

import java.util.List;

public interface CategoriaService {
    /**
     * Categorias
     *
     */
    List<Categoria> getListOfCategorias();

    Categoria findCategoriaById(CategoriaDTO dto);

    Categoria saveCategoria(CategoriaDTO dto);

    void deleteCategoria(Long id);

    Categoria editCategoria(CategoriaDTO dto, Long id);
}
