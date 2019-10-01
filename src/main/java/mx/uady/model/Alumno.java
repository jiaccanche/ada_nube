package mx.uady.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private String nombre;
    
    @Column
    private String licenciatura;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    public Alumno() {
    }

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLicenciatura() {
        return this.licenciatura;
    }

    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
    }
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }
    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the equipos
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * @param equipos the equipos to set
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }



}