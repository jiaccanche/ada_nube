package mx.uady.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidAlumnoException extends RuntimeException{
  public InvalidAlumnoException(){
      super("El alumno no existe con la matricula");
  }
}