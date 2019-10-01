package mx.uady.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uady.repository.AlumnoRepository;
import mx.uady.repository.EquipoRepository;
import mx.uady.model.Equipo;
import mx.uady.model.exception.BadRequestException;
import mx.uady.model.exception.InvalidEquipoException;
import mx.uady.model.request.EquipoRequest;

@Service
public class EquipoService {

  @Autowired
  private EquipoRepository equipoRepository;

  public List<Equipo> getEquipos() {
    return equipoRepository.findAll();
  }

  public Equipo getEquipo(Integer id) {
    Equipo equipoEncontrado;
    try{
      equipoEncontrado = equipoRepository.findById(id).get();
    }
    catch(NoSuchElementException e){
      throw new InvalidEquipoException();
      
    }
     
    return equipoEncontrado;
  }

  public Equipo crear(EquipoRequest equipo) {
    Equipo equipoCrear = new Equipo();
    equipoCrear.setModelo(equipo.getModelo());

    return equipoRepository.save(equipoCrear);

  }

  public String borrar(Integer idEquipo) {
    Optional<Equipo> equipoBorrar = equipoRepository.findById(idEquipo);
    if(equipoBorrar.isPresent()){
      equipoRepository.deleteById(equipoBorrar.get().getId());
      return "El equipo ha sido eliminado";
    }
    else{
      throw new InvalidEquipoException();
    }
  }

  public String editar(EquipoRequest equipo, Integer id) {
    Optional<Equipo> equipoEditar = equipoRepository.findById(id);
    if(equipoEditar.isPresent()){
      equipoEditar.get().setModelo(equipo.getModelo());
      equipoRepository.save(equipoEditar.get());
      return "El equipo fue actualizado";
    }
    else{
      throw new InvalidEquipoException();
    }
  }

}