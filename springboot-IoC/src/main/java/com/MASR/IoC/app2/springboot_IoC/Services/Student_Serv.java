package com.MASR.IoC.app2.springboot_IoC.Services;

import com.MASR.IoC.app2.springboot_IoC.Handler.ResourceNotFoundException;
import com.MASR.IoC.app2.springboot_IoC.Models.Student;
import com.MASR.IoC.app2.springboot_IoC.Repositories.RepoStudent_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Servicio con Logica del Negocio//
@Service
public class Student_Serv implements Student_Serv_Interface {

    //Dependencias por Interfaz//
    @Autowired
    private RepoStudent_interface repoStudent;

    @Override
    public List<Student> mostrar() {

        List<Student> estudiantes = repoStudent.getStudents();
        //Instanciar Estudiante con promedio//
        List<Student> estudiantesConPromedio = estudiantes.stream()
                .map(student -> new Student(student.getID(), student.getNombre(), student.getApellido(),
                        student.getEdad(), student.getCalif1(), student.getCalif2(), student.getCalif3(),
                        (student.getCalif1() + student.getCalif2() + student.getCalif3()) / 3)) // Calcula y asigna el promedio
                .collect(Collectors.toList());

        return estudiantesConPromedio;
    }

    @Override
    public Student buscar(Long ID) {
        return repoStudent.findByID(ID)
                .orElseThrow(() -> new ResourceNotFoundException("ID no encontrado : "));
    }
}
