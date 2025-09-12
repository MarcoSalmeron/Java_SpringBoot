package com.futuro_digital.demo.Ecommerce.Service;

import com.futuro_digital.demo.Ecommerce.DTO.UsuarioDTO;
import com.futuro_digital.demo.Ecommerce.Entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getListOfUsuarios();

    Usuario findUsuarioById(UsuarioDTO dto);

    Usuario saveUsuario(UsuarioDTO dto);

    void deleteUsuario(UsuarioDTO dto);


}
