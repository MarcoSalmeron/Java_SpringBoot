package com.MASR.IoC.app2.springboot_IoC.Services;


import com.MASR.IoC.app2.springboot_IoC.Models.Student;
import java.util.List;
import java.util.Optional;

//Interfaz a implementar Metodos//
public interface Student_Serv_Interface {

    //Mostrar//
    List<Student> mostrar();

    //Buscar//
    Student buscar(Long ID);
}
