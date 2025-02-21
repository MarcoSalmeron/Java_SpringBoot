package com.MASR.IoC.app2.springboot_IoC.DTO;


//Encapsular Informacion de Modelos//
public class StudentTutorDTO {

    //Atributos//
    private String nombreStudent;
    private Double califStudent;
    private String nombreTutor;
    private int sueldoTutor;

    //GET & SET//
    public String getNombreStudent() {
        return nombreStudent;
    }

    public void setNombreStudent(String nombreStudent) {
        this.nombreStudent = nombreStudent;
    }

    public Double getCalifStudent() {
        return califStudent;
    }

    public void setCalifStudent(Double califStudent) {
        this.califStudent = califStudent;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    public int getSueldoTutor() {
        return sueldoTutor;
    }

    public void setSueldoTutor(int sueldoTutor) {
        this.sueldoTutor = sueldoTutor;
    }
}
