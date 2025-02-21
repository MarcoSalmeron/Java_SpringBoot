package com.MASR.IoC.app2.springboot_IoC.Repositories;

import com.MASR.IoC.app2.springboot_IoC.Models.Student;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Repo para Acceso a Datos//
@Repository
public class RepoStudent implements RepoStudent_interface {

    List<Student> datos;

    //Simular Base de Datos//
    @Override
    public List<Student> getStudents() {
        return this.datos = Arrays.asList
                (
                        new Student(01L,"Marco","Ramirez",21,7.7,7.8,8.0,null),
                        new Student(02L,"Sergio","Gonzales",24,7.0,8.8,7.5,null),
                        new Student(03L,"Omar","Salmeron",19,8.7,7.0,9.0,null),
                        new Student(04L,"Valentin","Elizalde",38,5.0,7.5,6.0,null)
                );
    }

    @Override
    public Optional<Student> findByID(Long ID) {
        return datos
                .stream()
                .filter(s -> s.getID().equals(ID))
                .findFirst();
    }
}
