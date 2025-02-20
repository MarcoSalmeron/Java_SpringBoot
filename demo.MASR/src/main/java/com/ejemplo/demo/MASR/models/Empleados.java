package com.ejemplo.demo.MASR.models;

//Modelo a pasar a la Vista WEB//
public class Empleados {

    //Atributos//
    private String nombre,puesto,direccion;
    private int numero,salario,horas;

    //Constructor para Iniciar Atributos//
    public Empleados
    (String nombre, String puesto, String direccion, int numero, int salario, int horas)
    {
        this.nombre=nombre;
        this.puesto=puesto;
        this.direccion=direccion;
        this.numero=numero;
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

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion(){return direccion;}

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero(){return numero;}

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getSalario(){return salario;}

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getHoras(){return horas;}
}
