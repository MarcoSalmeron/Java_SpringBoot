package com.MASR.IoC.app2.springboot_IoC.Services;

import com.MASR.IoC.app2.springboot_IoC.Models.Tutor;

import java.util.List;
import java.util.Optional;

//Interfaz a implementar metodos//
public interface Tutor_Serv_Interface {

    //Mostrar//
    public List<Tutor> mostrar();

    //Buscar//
    public Tutor buscar(Long ID);
}
