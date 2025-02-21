package com.MASR.IoC.app2.springboot_IoC.Models;


//Modelo a Abstraer//
public class Student {

    //Atributos//
    private Long ID;
    private String nombre,apellido;
    private int edad;
    private Double calif1,calif2,calif3, promedio;

    //Constructor//
    public Student
    (Long ID, String nombre, String apellido, int edad, Double calif1, Double calif2, Double calif3, Double promedio) {
        this.ID = ID;
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.calif1=calif1;
        this.calif2=calif2;
        this.calif3=calif3;
        this.promedio=promedio;
    }

    //GET & SET//
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Double getCalif1() {
        return calif1;
    }

    public void setCalif1(Double calif1) {
        this.calif1 = calif1;
    }

    public Double getCalif2() {
        return calif2;
    }

    public void setCalif2(Double calif2) {
        this.calif2 = calif2;
    }

    public Double getCalif3() {
        return calif3;
    }

    public void setCalif3(Double calif3) {
        this.calif3 = calif3;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }
}
