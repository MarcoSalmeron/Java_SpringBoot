package com.ejemplo.demo.MASR.controllers;

import com.ejemplo.demo.MASR.models.DTO.JefeDTO;
import com.ejemplo.demo.MASR.models.Jefe;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

//Peticiones http con Rest Controller//
@RestController
@RequestMapping("/api")
public class JefeRestController{

    Jefe jefe1 = new Jefe("Antonio","Director de Desarrollo",50000,10000);

    //Mappear Ruta y tipo de Metodo//
    @RequestMapping(path = "/Jefe")
    public Map<String,Object> info(){

        Map<String,Object> rest = new LinkedHashMap<>();
        rest.put("Titulo","Modelo Jefe");
        rest.put("Jefe-1",jefe1);

        return rest;
    }

    //Mappear Ruta y tipo de Metodo//
    @RequestMapping(path = "/JefeDTO", method = RequestMethod.GET)
    public JefeDTO info2(){

        JefeDTO jefe2 = new JefeDTO();
        jefe2.setNombre(jefe1.getNombre());
        jefe2.setPuesto(jefe1.getPuesto());
        jefe2.setSalario(jefe1.getSalario());
        return jefe2;
    }
}
