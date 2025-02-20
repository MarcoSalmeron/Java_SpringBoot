package com.ejemplo.demo.MASR.controllers;


import com.ejemplo.demo.MASR.models.DTO.JefeDTO;
import com.ejemplo.demo.MASR.models.DTO.ParamDTO;
import org.springframework.web.bind.annotation.*;

//Controlador para manejar solicitudes http// Vista Json//
@RestController
@RequestMapping("/api/param2")
public class ParamController2 {

    //Ruta y tipo de Metodo URL//
    @RequestMapping(path = "/vista3", method = RequestMethod.GET)
    public JefeDTO datosJefe(
                        @RequestParam(required = false, defaultValue = "nombre vacio") String nombre,
                        @RequestParam(required = false, defaultValue = "0") int salario,
                        @RequestParam(required = false, defaultValue = "sin puesto") String puesto
                            ){
        JefeDTO jefe1 = new JefeDTO();
        jefe1.setNombre(nombre);
        jefe1.setPuesto(puesto);
        jefe1.setSalario(salario);
        return  jefe1;
    }

    @RequestMapping(path = "/vista4/{datos}", method = RequestMethod.GET)
    public ParamDTO obtenerdatos(@PathVariable String datos){
        ParamDTO obj = new ParamDTO();
        obj.setInfo(datos);
        return obj;
    }

}
