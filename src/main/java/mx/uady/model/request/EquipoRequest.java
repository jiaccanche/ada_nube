package mx.uady.model.request;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class EquipoRequest{

    @NotNull(message = "No nulo")
    @Size(min = 5, max = 50, message 
      = "No valido")
    @NotEmpty(message = "No VACIO")
    private String modelo;


    public EquipoRequest (){}

    
    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}