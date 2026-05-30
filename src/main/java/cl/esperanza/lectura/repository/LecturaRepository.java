package cl.esperanza.lectura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.esperanza.lectura.model.Lectura;

@Repository
public interface LecturaRepository extends JpaRepository<Lectura, Integer> {
    List<Lectura> findByRunSocio(String runSocio);

    Optional<Lectura> findByRunSocioAndPeriodo(String runSocio, String periodo);
}