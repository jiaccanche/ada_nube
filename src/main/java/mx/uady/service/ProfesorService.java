package mx.uady.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uady.model.Profesor;
import mx.uady.model.exception.BadRequestException;
import mx.uady.model.request.ProfesorRequest;
import mx.uady.repository.ProfesorRepository;

@Service
public class ProfesorService{

    @Autowired
    ProfesorRepository profesorRepository;

    public List<Profesor> getAllProfesores(){
        return profesorRepository.findAll();
    }

	public Profesor getProfesorById(Integer id) {
        Optional<Profesor> profe = profesorRepository.findById(id);
        if (!profe.isPresent()) {
            throw new BadRequestException();
        }
        return profe.get();
	}

	public Profesor createProfesor(ProfesorRequest request) {
        if (request.getId() != null) {
            throw new BadRequestException();
        }
        Profesor profe = new Profesor();
        profe.setNombre(request.getNombre());
        profe.setHoras(request.getHoras());
        return profesorRepository.save(profe);
    }

	public Profesor updateProfesor(ProfesorRequest request) {
        if (request.getId() == null) {
            return createProfesor(request);
        }
        Profesor profe = new Profesor();
        profe.setId(request.getId());
        profe.setNombre(request.getNombre());
        profe.setHoras(request.getHoras());
        return profesorRepository.save(profe);
	}

	public void deleteProfesor(Integer id) {
        profesorRepository.deleteById(id);
	}
    

}