package com.ejemplo.demo.MASR.controllers;

import com.ejemplo.demo.MASR.models.Empleados;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

//Controlador para peticiones http
@Controller
public class EmpleadoController {

    //Ruta y tipo de Metodo//
    @RequestMapping(path = "/Empleados", method = RequestMethod.GET)
    public String info(Model modelo){
        //Instanciar Clase Empleados
        Empleados emp1 = new Empleados("Marco","Delivery Mannager","Jacarandas #7",228311030,20000,500);

        //Pasar Datos a la Instancia//
        modelo.addAttribute("Titulo","Ejercicio3 Spring Boot");
        modelo.addAttribute("emp",emp1);
        return "Empleados"; //Retorna Vista//
    }

    //Datos de la clase en Models
    @ModelAttribute("Empleados")
    public List<Empleados> listaEmpleados(){
        return Arrays.asList(
                new Empleados("Marco","Asistente General","Jacarandas 7",228311040,20000,500),
                new Empleados("Antonio","Director","Huehuetoca 6", 12345678,45000,1000),
                new Empleados("Steven","Desarrollador","Amapolas 3", 576489,34000,600)
        );
    }
}

