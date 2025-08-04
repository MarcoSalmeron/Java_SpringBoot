package com.futuro_digital.dockerized.postgresql.Repositories;

import com.futuro_digital.dockerized.postgresql.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Repo extends JpaRepository<User,Long> {
}
