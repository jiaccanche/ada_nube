package mx.uady.model.request;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class AlumnoRequest {
    private Integer id;

    @NotNull(message = "No nulo")
    @Size(min = 5, max = 50, message 
      = "No valido")
    @NotEmpty(message = "No VACIO")
    private String nombre;
    
    @NotNull(message = "No nulo")
    @NotEmpty(message = "No VACIO")
    @Size(min = 9, max = 20, message 
      = "No valido")
    private String licenciatura;

    private Integer usuario;
    private Integer equipo;


    public AlumnoRequest() {
       
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the licenciatura
     */
    public String getLicenciatura() {
        return licenciatura;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @param licenciatura the licenciatura to set
     */
    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
    }

    /**
     * @param equipo the equipo to set
     */
    public void setEquipo(Integer equipo) {
        this.equipo = equipo;
    }
    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }
    /**
     * @return the equipo
     */
    public Integer getEquipo() {
        return equipo;
    }
    /**
     * @return the usuario
     */
    public Integer getUsuario() {
        return usuario;
    }
}