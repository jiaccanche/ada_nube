package mx.uady.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.uady.model.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    public Optional<Equipo> findById(Integer idEquipo);

}
