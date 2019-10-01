package mx.uady.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioRequest {

    @NotNull(message = "No nulo")
    @Size(min = 5, max = 50, message 
      = "No valido (Mínimo 5 caracteres)")
    @NotEmpty(message = "No Vacio")
    private String usuario;

    @NotNull(message = "No nulo")
    @Size(min = 5, max = 50, message 
      = "No valido (Mínimo 5 caracteres)")
    @NotEmpty(message = "No VACIO")
    private String password;

    private Integer id;


    public UsuarioRequest(){
        
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }


    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

}