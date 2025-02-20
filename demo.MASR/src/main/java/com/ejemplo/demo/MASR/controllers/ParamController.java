package com.ejemplo.demo.MASR.controllers;

import com.ejemplo.demo.MASR.models.DTO.ParamDTO;
import com.ejemplo.demo.MASR.models.Empleados;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

//Controlador con Vista JSON//
@RestController
@RequestMapping("/api/param")
public class ParamController {

    //Valores en propiedades//
    @Value("${config.usuario}")
    private String usuario;
    @Value("${config.contra}")
    private int contra;
    @Value("${config.datos}")
    private String[] datos;


    //Ruta y tipo de Metodo URL//
    @RequestMapping(path = "/vista", method = RequestMethod.GET)
    public ParamDTO info(@RequestParam(required = false, defaultValue = "Parametro Vacio") String x){
        ParamDTO objeto = new ParamDTO();
        objeto.setInfo(x);
        return objeto;
    }

    //Ruta y tipo de Metodo http GET//
    @RequestMapping(path = "/vista2/{x}", method = RequestMethod.GET)
    public ParamDTO info2(@PathVariable String x){
        ParamDTO obj = new ParamDTO();
        obj.setInfo(x);
        return obj;
    }

    //Ruta y Metodo http POST//
    @RequestMapping(path = "/solicitud", method = RequestMethod.POST)
    public Empleados creaEmple(@RequestBody(required = false) Empleados empe1){
        return  empe1;
    }

    @RequestMapping(path = "/solicitud2", method = RequestMethod.POST)
    public Map<String,Object> info3(){
        //Inyectar Valores de Dependencias//
        Map<String,Object> obj = new LinkedHashMap<>();
        obj.put("Usuario",usuario);
        obj.put("Contra", contra);
        obj.put("Datos", datos);
        return obj;
    }
}
