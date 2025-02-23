package com.Tirando.Codigo.CRUD.Services;

import com.Tirando.Codigo.CRUD.Models.Staff;
import com.Tirando.Codigo.CRUD.Repositories.RepoStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Servicio con CRUD//
@Service
public class ServStaff implements ServStaff_Interface {

    //Inyectar Dependencias//
    @Autowired
    private RepoStaff repoStaff;


    @Override
    public List<Staff> getStaff() {
        return repoStaff.findAll();
    }

    @Override
    public Staff findStaff(Long ID) {
        return repoStaff.findById(ID).orElseThrow(() -> new NullPointerException("Error, no existe el Staff con ID: " + ID));
    }


    @Override
    public Staff saveStaff(Staff staff) {
        return repoStaff.save(staff);
    }

    @Override
    public void deleteStaff(Long ID) {
        repoStaff.deleteById(ID);
    }

    @Override
    public Staff editStaff(Staff staff) {
        return this.saveStaff(staff);
    }
}
