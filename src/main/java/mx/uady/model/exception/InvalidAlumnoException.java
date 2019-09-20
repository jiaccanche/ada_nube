package mx.uady.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidAlumnoException extends RuntimeException{
  public InvalidAlumnoException(){
      super("El alumno no existe con la matricula");
  }
}