package com.Tirando.Codigo.demo.Archivos.Services;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Servicio que Gestiona Archivos//
@Service
public class ServArchivos implements  ServArchivos_Interface {

    @Override
    public String leer(String archivo) {
        //Leer Archivo//
        try {
        Path ruta = Paths.get(archivo);
            return Files.readString(ruta);
        } catch (IOException e) {
            throw new RuntimeException("Error al Leer Archivo: "+e.getMessage());
        }
    }

    @Override
    public String escritura(String archivo, String contenido) {
        //Escribir en Archivo//
        try{
            Path ruta = Paths.get(archivo);
            Files.writeString(ruta, contenido);
        }catch(IOException e){
            throw new RuntimeException("Error al Escribir en Archivo: "+e.getMessage());
        }
        return archivo;
    }

    @Override
    public String editar(String archivo, String buscar, String nuevo_contenido) {
        //Editar Archivo//
        try{
            Path ruta = Paths.get(archivo);
            String contenido = Files.readString(ruta);
            contenido = contenido.replace(buscar,nuevo_contenido);
            Files.writeString(ruta, contenido);
        }catch (IOException e){
            throw new RuntimeException("Error al Editar Archivo: "+e.getMessage());
        }
        return archivo;
    }


}
