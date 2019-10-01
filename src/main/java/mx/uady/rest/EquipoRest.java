package mx.uady.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uady.model.Equipo;
import mx.uady.model.request.EquipoRequest;
import mx.uady.service.EquipoService;

@RestController
public class EquipoRest {
    @Autowired
    private EquipoService equipoService = new EquipoService();

    @GetMapping("/equipo")
    public ResponseEntity< List<Equipo> > getAlumnos(){
        List<Equipo> equipos = equipoService.getEquipos();
        return ResponseEntity.ok(equipos);
    }

    @GetMapping("/equipo/{id}")
    public ResponseEntity<Equipo> getAlumno(@PathVariable Integer id){
        Equipo equipo = equipoService.getEquipo(id);
        return ResponseEntity.ok(equipo);
    }

    @PostMapping("equipo/registrar")
    public ResponseEntity<Equipo> crearAlumno(@Validated @RequestBody EquipoRequest equipo) {
        Equipo nuevoEquipo = equipoService.crear(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEquipo);
    }

    @DeleteMapping("/equipo/{id}")
    public ResponseEntity<String> deleteEquipo(@PathVariable Integer id){
        String mensaje = equipoService.borrar(id);
        return ResponseEntity.ok(mensaje);
    }

    @PutMapping("/equipo/{id}")
    public ResponseEntity<String> putAlumno(@Validated @RequestBody EquipoRequest body, @PathVariable Integer id){
        String mensaje = equipoService.editar(body,id);
        return ResponseEntity.ok(mensaje);
    }

}