package com.futuro_digital.demo.Ecommerce.Service;

import com.futuro_digital.demo.Ecommerce.DTO.ProductoDTO;
import com.futuro_digital.demo.Ecommerce.DTO.UsuarioDTO;
import com.futuro_digital.demo.Ecommerce.Entity.Favoritos;

import java.util.List;

public interface FavoritoService {

    List<Favoritos> getListOfFavoritos();

    Favoritos saveFavorito(ProductoDTO productoDTO, UsuarioDTO usuarioDTO);

    boolean deleteFavorito(Long id);
}
