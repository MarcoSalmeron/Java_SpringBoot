package FuturoDigital.Employees.Error_Handler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class Error_Controller {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handlerEntityNotFoundException(EntityNotFoundException ex){
        return new ResponseEntity<>("Problema ->"+ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handlerMissingParams(MissingServletRequestParameterException ex) {
        return new ResponseEntity<>("Falta el parámetro requerido: " + ex.getParameterName(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        return new ResponseEntity<>("Tipo de Dato Incorrecto en el Argumento... "+ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
