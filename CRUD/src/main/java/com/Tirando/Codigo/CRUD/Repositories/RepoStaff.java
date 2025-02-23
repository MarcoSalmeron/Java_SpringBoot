package com.Tirando.Codigo.CRUD.Repositories;

import com.Tirando.Codigo.CRUD.Models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repo con Acceso a Datos//
@Repository
public interface RepoStaff extends JpaRepository<Staff,Long> {
}
