package mx.uady.model.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AlumnoRequest {
    @NotNull(message = "No nulo")
    @Size(min = 5, max = 50, message 
      = "No valido")
    @NotEmpty(message = "No VACIO")
    private String nombre;
    
    @NotNull(message = "No nulo")
    @NotEmpty(message = "No VACIO")
    @Size(min = 9, max = 20, message 
      = "No valido")
    private String matricula;

    @Min(value = 18, message = "Tienes que ser mayor de 18")
    @Max(value = 30, message = "No puede ser mas grande que 30")
    private int edad;


    public AlumnoRequest() {
       
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}