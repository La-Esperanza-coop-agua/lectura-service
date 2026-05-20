package cl.esperanza.lectura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.esperanza.lectura.model.Lecturas;

@Repository
public interface LecturaRepository
        extends JpaRepository<Lecturas, Integer> {

}