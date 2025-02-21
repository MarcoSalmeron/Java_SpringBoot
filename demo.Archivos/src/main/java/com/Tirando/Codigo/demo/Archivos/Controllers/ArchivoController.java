package com.Tirando.Codigo.demo.Archivos.Controllers;



import com.Tirando.Codigo.demo.Archivos.Services.ServArchivos_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Manejar peticiones http//
@RestController
@RequestMapping("/api/Archivos")
public class ArchivoController {

    //Iniciar Servicios//
    @Autowired
    private ServArchivos_Interface servicio;


    @RequestMapping(path = "/Leer", method = RequestMethod.GET)
    public ResponseEntity<String> leerArchivo(@RequestParam String archivo){
        try {
            String ElArchivo = servicio.leer(archivo);
            return ResponseEntity.ok(ElArchivo);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("ERROR al leer: "+e.getMessage());
        }
    }

    @RequestMapping(path = "/Escribir", method = RequestMethod.POST)
    public ResponseEntity<String> escribirArchivo(@RequestParam String archivo,
                                                  @RequestParam String contenido){
        try{
            String ElArchivo = servicio.escritura(archivo,contenido);
            return ResponseEntity.ok(ElArchivo);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al Escribir: "+e.getMessage());
        }
    }

    @RequestMapping(path ="/Editar", method = RequestMethod.PUT)
    public ResponseEntity<String> editarArchivo(@RequestParam String archivo,
                                                @RequestParam String buscar,
                                                @RequestParam String contenido){
        try {
            String ElArchivo = servicio.editar(archivo, buscar, contenido);
            return ResponseEntity.ok(ElArchivo);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al Editar: "+e.getMessage());
        }
    }


}
