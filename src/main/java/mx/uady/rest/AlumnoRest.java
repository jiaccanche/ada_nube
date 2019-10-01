package mx.uady.rest;

import java.util.List;

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

import mx.uady.model.Alumno;
import mx.uady.model.request.AlumnoRequest;
import mx.uady.service.AlumnoService;

@RestController
public class AlumnoRest {

    @Autowired
    private AlumnoService alumnoService = new AlumnoService();
    
    @GetMapping("/alumno")
    public ResponseEntity< List<Alumno> > readAlumnos() {
        List<Alumno> alumnos = alumnoService.getAlumnos();
        return ResponseEntity.ok(alumnos);
    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<Alumno> readAlumno(@PathVariable("id") int id){
        Alumno a = alumnoService.getAlumno(id);
        return ResponseEntity.ok(a);

    }

    @PostMapping("/alumno")
    public ResponseEntity<Alumno> createAlumno(@RequestBody AlumnoRequest alumno) {
        Alumno a = alumnoService.crear(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(a);
    }

    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<String> deleteAlumno(@PathVariable int alumnoId){
        System.out.println(alumnoId);
        alumnoService.delete(alumnoId);
        return ResponseEntity.status(HttpStatus.OK).body("Alumno eliminado");
    } 

    @PutMapping("/alumno")
    public ResponseEntity<Alumno> updateAlumno(@RequestBody AlumnoRequest alumno){
        Alumno a = alumnoService.update(alumno);
        return ResponseEntity.status(HttpStatus.OK).body(a);
    }

}

