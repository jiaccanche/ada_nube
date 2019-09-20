package mx.uady.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uady.repository.AlumnoRepository;

import mx.uady.model.Alumno;

@Service
public class AlumnoService {
  
  @Autowired
  private AlumnoRepository alumnoRepository;

  public List<Alumno> getAlumnos(){
    return alumnoRepository.findAll();
  }

  public Alumno crear(Alumno alumno) {
    Alumno alumnoCrear = new Alumno();
    alumnoCrear.setNombre(alumno.getNombre());
    alumnoCrear.setLicenciatura(alumno.getLicenciatura());

    return alumnoRepository.save(alumnoCrear);
  }

}