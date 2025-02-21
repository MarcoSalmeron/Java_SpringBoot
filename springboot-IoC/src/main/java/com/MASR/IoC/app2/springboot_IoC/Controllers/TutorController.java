package com.MASR.IoC.app2.springboot_IoC.Controllers;

import com.MASR.IoC.app2.springboot_IoC.Models.Tutor;
import com.MASR.IoC.app2.springboot_IoC.Services.Tutor_Serv_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//Controlador para peticiones http//
@RestController
@RequestMapping("/api/Tutors")
public class TutorController {


    //Dependencias por Interfaz//
    @Autowired
    private Tutor_Serv_Interface servTutor;


    //Metodo y tipo de solicitud http//
    @RequestMapping(path = "/All", method = RequestMethod.GET)
    public List<Tutor> mostrarTutores(){
        return servTutor.mostrar();
    }

    //Metodo y tipo de solicitud http//
    @RequestMapping(path = "/Find/{ID}", method = RequestMethod.GET)
    public Tutor buscarTutor(@PathVariable Long ID){
        return servTutor.buscar(ID);
    }
}
