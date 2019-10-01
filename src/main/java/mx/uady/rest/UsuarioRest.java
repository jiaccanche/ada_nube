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

import mx.uady.model.Usuario;
import mx.uady.model.exception.BadRequestException;
import mx.uady.model.request.UsuarioRequest;
import mx.uady.repository.UsuarioRepository;
import mx.uady.service.UsuarioService;

@RestController
public class UsuarioRest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    /*
     * @GetMapping("/usuarios") public ResponseEntity< List<Usuario> > prueba(
     * 
     * @RequestHeader(value = "Authorization") String token ) {
     * 
     * 
     * Usuario usuario = UsuarioRepository.findByToken(token); if(usuario == null){
     * throw new BadRequestException(); }
     * 
     * 
     * List<Usuario> usuarios = usuarioService.getUsuarios(); return
     * ResponseEntity.ok(usuarios); }
     */

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> obtenerUsuario() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody UsuarioRequest request) {

        Usuario u = usuarioService.crear(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }

    @PutMapping("/usuario")
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody UsuarioRequest request) {
        Usuario u = usuarioService.update(request);
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Optional<Usuario>> eliminarUsuario(@PathVariable Integer id) {
        Optional<Usuario> u = usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Optional<Usuario>> getUsuario(@PathVariable Integer id) {
        Optional<Usuario> u = usuarioService.getUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioRequest request){

        Usuario usuario = usuarioRepository.findByUsuario(request.getUsuario());

        if(usuario == null){
            throw new BadRequestException();
        }

        if(!usuario.getPassword().equals(request.getPassword())){
            throw new BadRequestException();
        }

        return ResponseEntity.ok(usuario.getToken());
    }
}