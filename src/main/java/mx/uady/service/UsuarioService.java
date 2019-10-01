package mx.uady.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uady.model.Usuario;
import mx.uady.model.request.UsuarioRequest;
import mx.uady.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario crear(UsuarioRequest request) {
        Usuario usuarioCrear = new Usuario();

        usuarioCrear.setUsuario(request.getUsuario());
        usuarioCrear.setPassword(request.getPassword());

        String token = UUID.randomUUID().toString();
        usuarioCrear.setToken(token);

        return usuarioRepository.save(usuarioCrear);
    }

    public Usuario update(UsuarioRequest request) {
        Optional<Usuario> usuarioUpdate = usuarioRepository.findById(request.getId());

      if(usuarioUpdate.isPresent()){
          Usuario usuarioToUpdate = usuarioUpdate.get();
          usuarioToUpdate.setId(request.getId());
          usuarioToUpdate.setUsuario(request.getUsuario());
          usuarioToUpdate.setPassword(request.getPassword());
          return usuarioRepository.save(usuarioToUpdate);
      }else{
          return this.crear(request);
      }


  }

  public Optional<Usuario> delete(Integer id) {
      Optional<Usuario> usuarioDelete = usuarioRepository.findById(id);
      usuarioRepository.deleteById(id);
      return usuarioDelete;
  }

  public Optional<Usuario> getUsuario(Integer id) {
      return usuarioRepository.findById(id);
  }

}