package mx.uady.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.uady.model.Profesor;
import mx.uady.model.request.ProfesorRequest;
import mx.uady.service.ProfesorService;

@RestController
public class ProfesorRest {

    @Autowired
    private ProfesorService profesorService = new ProfesorService();

    @GetMapping("/profesores")
    public ResponseEntity<List<Profesor>> getAllProfesores() {
        List<Profesor> profesores = profesorService.getAllProfesores();
        return ResponseEntity.ok(profesores);
    }

    @GetMapping("/profesores/{id}")
    public ResponseEntity<Profesor> getProfesorById(@PathVariable Integer id) {
        Profesor profe = profesorService.getProfesorById(id);
        return ResponseEntity.ok(profe);
    }

    @PostMapping("/profesores")
    public ResponseEntity<Profesor> createProfesor(@RequestBody ProfesorRequest request){
        return ResponseEntity.ok(profesorService.createProfesor(request));
    }

    @PutMapping("/profesores")
    public ResponseEntity<Profesor> updateProfesor(@RequestBody ProfesorRequest request){
        return ResponseEntity.ok(profesorService.updateProfesor(request));
    }

    @DeleteMapping("/profesores/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable Integer id){
        profesorService.deleteProfesor(id);
        return ResponseEntity.ok().build();
    }

}