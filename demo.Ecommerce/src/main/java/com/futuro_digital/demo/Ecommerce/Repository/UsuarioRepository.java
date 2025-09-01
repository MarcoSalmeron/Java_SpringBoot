package com.futuro_digital.demo.Ecommerce.Repository;

import com.futuro_digital.demo.Ecommerce.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
