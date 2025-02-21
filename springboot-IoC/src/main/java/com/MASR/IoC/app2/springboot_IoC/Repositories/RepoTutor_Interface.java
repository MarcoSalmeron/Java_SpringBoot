package com.MASR.IoC.app2.springboot_IoC.Repositories;

import com.MASR.IoC.app2.springboot_IoC.Models.Tutor;

import java.util.List;
import java.util.Optional;

//Interface a Implementar Metodos//
public interface RepoTutor_Interface {

    //Mostrar//
    public List<Tutor> getTutors();
    //Buscar//
    public Optional<Tutor> findByID(Long ID);
}
