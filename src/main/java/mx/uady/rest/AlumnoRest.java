package mx.uady.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.uady.model.Alumno;
import mx.uady.service.AlumnoService;

@RestController
public class AlumnoRest {

    @Autowired
    private AlumnoService alumnoService = new AlumnoService();
    
    @GetMapping("/alumno")
    public ResponseEntity< List<Alumno> > prueba() {
        List<Alumno> alumnos = alumnoService.getAlumnos();
        return ResponseEntity.ok(alumnos);
    }

    @PostMapping("/alumno")
    public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno alumno) {
        Alumno a = alumnoService.crear(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(a);
    }

}

