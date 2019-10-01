package mx.uady.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Equipos")
public class Equipo{
    @Id
    private Integer id;

    @Column
    private String modelo;

    /*@OneToMany( mappedBy = "equipo")
    private List<Alumno> alumnos;
    public Equipo (){}*/

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }
    /*
     * @return the alumnos
     
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * @param alumnos the alumnos to set
     
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }*/
    
}