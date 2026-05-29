package cl.esperanza.lectura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.esperanza.lectura.model.Lectura;
import java.util.List;

@Repository
public interface LecturaRepository extends JpaRepository<Lectura, Integer> {
    List<Lectura> findByRunSocio(String runSocio);
}