package com.futuro_digital.demo.Ecommerce.Repository;

import com.futuro_digital.demo.Ecommerce.Entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion,Long> {
}
