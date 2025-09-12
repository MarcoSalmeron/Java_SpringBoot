package com.futuro_digital.demo.Ecommerce.Service;

import com.futuro_digital.demo.Ecommerce.DTO.ProductoDTO;
import com.futuro_digital.demo.Ecommerce.DTO.UsuarioDTO;
import com.futuro_digital.demo.Ecommerce.Entity.Favoritos;
import com.futuro_digital.demo.Ecommerce.Repository.FavoritosRepository;
import com.futuro_digital.demo.Ecommerce.Repository.ProductoRepository;
import com.futuro_digital.demo.Ecommerce.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FavoritoServiceImpl implements FavoritoService {

    @Autowired
    private final FavoritosRepository favoritosRepository;

    @Autowired
    private final ProductoRepository productoRepository;

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Favoritos> getListOfFavoritos() {
        return favoritosRepository.findAll();
    }

    @Override
    @Transactional
    public Favoritos saveFavorito(ProductoDTO productoDTO, UsuarioDTO usuarioDTO) {
        var producto = productoRepository.findById(productoDTO.id())
                .orElseThrow(() -> new IllegalStateException("Producto inválido"));
        var usuario = usuarioRepository.findById(usuarioDTO.idUsuario())
                .orElseThrow(() -> new IllegalStateException("Usuario inválido"));

        // Validar que no se repita el mismo producto para el mismo usuario
        if (favoritosRepository.existsByUsuario_IdAndProducto_Id( usuario.getId(), producto.getId() )) {
            throw new IllegalStateException("Este producto ya está en tus favoritos");
        }

        var favorito = Favoritos.builder()
                .usuario(usuario)
                .producto(producto)
                .fecha(LocalDate.now())
                .build();

        return favoritosRepository.save(favorito);
    }

    @Override
    @Transactional
    public boolean deleteFavorito(Long productoId) {
        try {
            // Si no existe, no hay nada que eliminar
            if (!favoritosRepository.existsById(productoId)) {
                return false;
            }
            favoritosRepository.deleteById(productoId);
            return true;

        } catch (Exception e) {
            log.info("Error al eliminar favorito con id : "+productoId);
            return false;
        }
    }

}
