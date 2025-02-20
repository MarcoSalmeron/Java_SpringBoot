package com.ejemplo.demo.MASR.models.DTO;

//Objecto de Transferencia de Datos//
public class JefeDTO {

    //Atributos//
    private String nombre,puesto;
    private int salario;


    //Metodos SET y GET//
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

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
