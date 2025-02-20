package com.ejemplo.demo.MASR.models;

//Modelo a pasar a Vista Api Rest//
public class Jefe {

    //Atributos//
    private String nombre,puesto;
    private int salario,horas;

    //Constructos//
    public Jefe
    (String nombre, String puesto, int salario, int horas)
    {
        this.nombre=nombre;
        this.puesto=puesto;
        this.salario=salario;
        this.horas=horas;
    }

    //Metodos SET//
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(){return nombre;}

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPuesto(){return puesto;}

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getSalario(){return salario;}

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getHoras(){return horas;}
}
