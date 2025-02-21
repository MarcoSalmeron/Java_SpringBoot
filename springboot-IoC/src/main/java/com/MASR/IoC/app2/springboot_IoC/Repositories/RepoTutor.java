package com.MASR.IoC.app2.springboot_IoC.Repositories;

import com.MASR.IoC.app2.springboot_IoC.Models.Tutor;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Repo para Acceder a Datos//
@Repository
public class RepoTutor implements RepoTutor_Interface {

    List<Tutor> datos;

    //Simular Base de Datos//
    @Override
    public List<Tutor> getTutors() {
        return this.datos= Arrays.asList(
                new Tutor(01L,"Cristian","Desarrollador","Backend",35000),
                new Tutor(02L,"Gorge","Diseño Web","SoftSkills",22500),
                new Tutor(03L,"Joel","Diseño Web","FrontEnd",28000),
                new Tutor(04L,"Marco","Desarrollador","FullStack",60000)
        );
    }

    @Override
    public Optional<Tutor> findByID(Long ID) {
        return datos
                 .stream()
                .filter(t -> t.getID().equals(ID))
                .findFirst();
    }
}
