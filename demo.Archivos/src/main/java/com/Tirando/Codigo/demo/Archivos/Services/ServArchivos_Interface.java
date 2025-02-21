package com.Tirando.Codigo.demo.Archivos.Services;

//Interfaz a Implementar Metodos//
public interface ServArchivos_Interface {

    //Leer Archivo//
    public String leer(String archivo);

    //Escritura//
    public String escritura(String archivo, String contenido);

    //Edicion//
    public String editar(String archivo, String buscar, String nuevo_contenido);
}
