package com.futuro_digital.demo.Ecommerce.Service;

import com.futuro_digital.demo.Ecommerce.DTO.ProductoDTO;
import com.futuro_digital.demo.Ecommerce.DTO.UsuarioDTO;
import com.futuro_digital.demo.Ecommerce.Entity.Favoritos;
import com.futuro_digital.demo.Ecommerce.Entity.Usuario;
import com.futuro_digital.demo.Ecommerce.Repository.FavoritosRepository;
import com.futuro_digital.demo.Ecommerce.Repository.ProductoRepository;
import com.futuro_digital.demo.Ecommerce.Repository.RolRepository;
import com.futuro_digital.demo.Ecommerce.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private final ProductoRepository productoRepository;

    @Autowired
    private final FavoritosRepository favoritosRepository;

    @Autowired
    private final RolRepository rolRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getListOfUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findUsuarioById(UsuarioDTO dto) {
        return usuarioRepository
                .findById(dto.idUsuario())
                .orElseThrow(()->new EntityNotFoundException("Usuario con ID :"+dto.idUsuario()+" no encontrado..."));
    }

    @Override
    @Transactional
    public Usuario saveUsuario(UsuarioDTO dto) {
        var rol = rolRepository.findById(dto.roleDTO().idRol()).get();

        var user = Usuario.builder()
                .username(dto.username())
                .password(dto.password())
                .direccion(dto.direccion())
                .rol(rol)
                .build();
        return usuarioRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUsuario(UsuarioDTO dto) {
        usuarioRepository.deleteById(dto.idUsuario());
    }

    @Override
    @Transactional
    public Favoritos guardarFavorito(ProductoDTO dto, UsuarioDTO user) {
        var usuario = usuarioRepository.findById(user.idUsuario()).get();
        var producto = productoRepository.findById(dto.id()).get();

        var favorito = Favoritos.builder()
                .usuario(usuario)
                .producto(producto)
                .fecha(LocalDate.now())
                .build();
        return favoritosRepository.save(favorito);
    }
}
