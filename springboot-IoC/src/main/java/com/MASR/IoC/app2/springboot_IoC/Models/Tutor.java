package com.MASR.IoC.app2.springboot_IoC.Models;


//Modelo a Abstraer//
public class Tutor {

    //Atributos//
    private Long ID;
    private String nombre, puesto, curso;
    private int sueldo;

    //Constructor//
    public Tutor(Long ID, String nombre, String puesto, String curso, int sueldo)
    {
        this.ID=ID;
        this.nombre=nombre;
        this.puesto=puesto;
        this.curso=curso;
        this.sueldo=sueldo;
    }

    //SET & GET//
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
}
