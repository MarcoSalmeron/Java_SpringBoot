package com.Tirando.Codigo.CRUD.Services;

import com.Tirando.Codigo.CRUD.Models.Staff;

import java.util.List;

//Interfaz a implementar Metodos//
public interface ServStaff_Interface {

    //Mostrar//
    public List<Staff> getStaff();

    //Buscar//
    public Staff findStaff(Long ID);

    //Guardar//
    public Staff saveStaff(Staff staff);

    //Eliminar//
    public void deleteStaff(Long ID);

    //Editar//
    public Staff editStaff(Staff staff);
}
