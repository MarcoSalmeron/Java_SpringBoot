package com.futuro_digital.demo.Ecommerce.Repository;

import com.futuro_digital.demo.Ecommerce.Entity.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritosRepository extends JpaRepository<Favoritos,Long> {
}
