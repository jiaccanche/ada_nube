package mx.uady.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.uady.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Optional<Usuario> findById(Integer id);

    public Usuario findByUsuario(String usuario);

    public static Usuario findByToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}
}