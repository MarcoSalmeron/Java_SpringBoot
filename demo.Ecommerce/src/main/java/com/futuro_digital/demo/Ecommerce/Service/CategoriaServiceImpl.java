package com.futuro_digital.demo.Ecommerce.Service;

import com.futuro_digital.demo.Ecommerce.DTO.CategoriaDTO;
import com.futuro_digital.demo.Ecommerce.Entity.Categoria;
import com.futuro_digital.demo.Ecommerce.Repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getListOfCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria findCategoriaById(CategoriaDTO dto) {
        return categoriaRepository.findById(dto.id())
                .orElseThrow(() -> new IllegalStateException("Categoria con ID :"+dto.id()+" no encontrado..."));
    }

    @Override
    @Transactional
    public Categoria saveCategoria(CategoriaDTO dto) {
        var categoria = Categoria.builder()
                .categoria(dto.categoria())
                .descripcion(dto.descripcion())
                .url_imagen(dto.url_imagen())
                .build();
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Categoria editCategoria(CategoriaDTO dto, Long id) {
        var catOpt = categoriaRepository.findById(id);

        if (id == null || catOpt.isEmpty()) {
            throw new IllegalStateException("Categoria no encontrada con ID: " + id);
        }

        var categoria = catOpt.get();

        // Actualizar los campos del producto con los valores del DTO
        categoria.setCategoria(dto.categoria());
        categoria.setDescripcion(dto.descripcion());
        categoria.setUrl_imagen(dto.url_imagen());

        return categoriaRepository.save(categoria);

    }
}
