package Tirando.Codigo.QueryMethod.Errors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

//Capturar errores dentro del Controlador//
@ControllerAdvice
public class ErrorHandler {

    //Error si faltan parametros//
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<String> handleNoHandlerFoundException(NoHandlerFoundException e) {
        return new ResponseEntity<>("Error: faltan parámetros " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    //Error al introducir otro tipo de Dato//
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        return new ResponseEntity<>("Error: tipo de dato incorrecto "+e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //Error si no existe Entidad//
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handlerEntityNotFoundException(EntityNotFoundException e){
        return new ResponseEntity<>("Error: Entidad Inexistente "+e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
