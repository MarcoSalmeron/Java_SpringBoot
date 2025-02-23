package com.Tirando.Codigo.CRUD.Controllers;

import com.Tirando.Codigo.CRUD.Models.Staff;
import com.Tirando.Codigo.CRUD.Services.ServStaff_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controlar peticiones http//
@RestController
@RequestMapping(path = "/api/staff")
public class StaffController {

    //Inyectar Dependencias//
    @Autowired
    private ServStaff_Interface servStaff;

    //Mostrar//
    @RequestMapping(path = "/All", method = RequestMethod.GET)
    public List<Staff> All(){
        return servStaff.getStaff();
    }

    //Buscar//
    @RequestMapping(path = "/Find/{ID}", method = RequestMethod.POST)
    public Staff Find(@PathVariable Long ID){
        return  servStaff.findStaff(ID);
    }

    //Guardar//
    @RequestMapping(path = "/Save", method = RequestMethod.PUT)
    public Staff Save(@RequestBody Staff staff){
        return servStaff.saveStaff(staff);
    }

    //Borrar//
    @RequestMapping(path = "/Delete/{ID}", method = RequestMethod.DELETE)
    public String Delete(@PathVariable Long ID){
        servStaff.deleteStaff(ID);
        return "Staff Eliminado";
    }

    //Editar//
    @RequestMapping(path = "/Edit", method = RequestMethod.PUT)
    public Staff Edit(@RequestBody Staff staff){
        return  servStaff.editStaff(staff);
    }
}
