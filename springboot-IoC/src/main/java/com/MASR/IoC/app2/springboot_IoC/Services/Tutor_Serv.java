package com.MASR.IoC.app2.springboot_IoC.Services;

import com.MASR.IoC.app2.springboot_IoC.Handler.ResourceNotFoundException;
import com.MASR.IoC.app2.springboot_IoC.Models.Tutor;
import com.MASR.IoC.app2.springboot_IoC.Repositories.RepoTutor_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Servicio con Logica del Negocio//
@Service
public class Tutor_Serv implements Tutor_Serv_Interface {

    //Dependencias por Interfaz//
    @Autowired
    private RepoTutor_Interface repoTutor;


    @Override
    public List<Tutor> mostrar() {
        return repoTutor.getTutors();
    }

    @Override
    public Tutor buscar(Long ID) {
        return repoTutor.findByID(ID)
                .orElseThrow(() -> new ResourceNotFoundException("ID no encontrado"));
    }
}
