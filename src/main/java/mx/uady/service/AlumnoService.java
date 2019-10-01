package mx.uady.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uady.repository.AlumnoRepository;

import mx.uady.model.Alumno;
import mx.uady.model.Equipo;
import mx.uady.model.Usuario;
import mx.uady.model.request.AlumnoRequest;

@Service
public class AlumnoService {
  
  @Autowired
  private AlumnoRepository alumnoRepository;

  public List<Alumno> getAlumnos(){
    return alumnoRepository.findAll();
  }

  public Alumno crear(AlumnoRequest alumno) {
    Alumno alumnoCrear = new Alumno();
    alumnoCrear.setNombre(alumno.getNombre());
    alumnoCrear.setLicenciatura(alumno.getLicenciatura());
    alumnoCrear.setEquipo(new Equipo());
    alumnoCrear.setUsuario(new Usuario());
    alumnoCrear.getUsuario().setId(alumno.getUsuario());
    alumnoCrear.getEquipo().setId(alumno.getEquipo());

    Alumno aux = alumnoRepository.save(alumnoCrear);
    return alumnoRepository.findById(aux.getId().intValue());
  }

  public Alumno update(AlumnoRequest alumno){
    Alumno alumno_exist;
    try{
      alumno_exist = alumnoRepository.findById(alumno.getId());
    }catch(NullPointerException e){
      alumno_exist = null;        
    }

    if(alumno_exist == null){
      return this.crear(alumno);
    }else{
      alumno_exist.setNombre(alumno.getNombre());
      alumno_exist.setLicenciatura(alumno.getLicenciatura());
      alumno_exist.setEquipo(new Equipo());
      alumno_exist.setUsuario(new Usuario());
      alumno_exist.getUsuario().setId(alumno.getUsuario());
      alumno_exist.getEquipo().setId(alumno.getEquipo());
      
      Alumno aux = alumnoRepository.save(alumno_exist);
      return alumnoRepository.findById(aux.getId().intValue());
    }




  }

  public void delete(int alumnoId) {
    alumnoRepository.deleteById(alumnoId);
  }
 
}