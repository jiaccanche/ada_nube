package mx.uady.model.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class ProfesorRequest {
    
    private Integer id;
    
    @NonNull
    @Size(min = 5, max = 50, message 
    = "No valido")
  @NotEmpty(message = "No VACIO")
    private String nombre;
    
    @NonNull
    @Min(value = 1, message = "Debe tener al menos una hora")
    @Max(value = 40, message = "No puede tener más de 40 horas")
    private Integer horas;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return the horas
     */
    public Integer getHoras() {
        return horas;
    }
    /**
     * @param horas the horas to set
     */
    public void setHoras(Integer horas) {
        this.horas = horas;
    }
}
