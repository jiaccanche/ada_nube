package mx.uady.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlumnoExistsException extends RuntimeException{
  public AlumnoExistsException(){
      super("El alumno existe con la matricula o el nombre");
  }
}