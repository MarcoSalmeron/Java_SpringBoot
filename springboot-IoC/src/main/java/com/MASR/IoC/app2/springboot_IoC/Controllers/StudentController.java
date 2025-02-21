package com.MASR.IoC.app2.springboot_IoC.Controllers;

import com.MASR.IoC.app2.springboot_IoC.Models.Student;
import com.MASR.IoC.app2.springboot_IoC.Services.Student_Serv_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//Controlador para peticiones http//
@RestController
@RequestMapping("/api/Students")
public class StudentController {

    //Dependencias por Interfaz//
    @Autowired
    private Student_Serv_Interface servStudent;

    //Ruta y tipo de metodo http//
    @RequestMapping(path = "/All", method = RequestMethod.GET)
    public List<Student> mostrarEstudiantes(){
        return servStudent.mostrar();
    }

    //Ruta y metodo http//
    @RequestMapping(path = "/Find/{ID}")
    public Student buscarEstudiante(@PathVariable Long ID){
        return servStudent.buscar(ID);
    }
}
