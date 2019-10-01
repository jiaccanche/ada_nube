package mx.uady.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidEquipoException extends RuntimeException{
  public InvalidEquipoException(){
      super("El equipo no existe con ese id");
  }
}