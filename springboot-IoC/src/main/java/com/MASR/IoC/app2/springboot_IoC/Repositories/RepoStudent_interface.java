package com.MASR.IoC.app2.springboot_IoC.Repositories;

import com.MASR.IoC.app2.springboot_IoC.Models.Student;

import java.util.List;
import java.util.Optional;

//Interfaz a conectar Metodos//
public interface RepoStudent_interface {

    //Mostrar//
    public List<Student> getStudents();

    //Buscar//
    public Optional<Student> findByID(Long ID);
}
