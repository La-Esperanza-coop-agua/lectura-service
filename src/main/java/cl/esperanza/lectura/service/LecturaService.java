package cl.esperanza.lectura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.esperanza.lectura.model.Lectura;
import cl.esperanza.lectura.repository.LecturaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class LecturaService {

    @Autowired
    private LecturaRepository lecturaRepo;

    public List<Lectura> obtenerPorSocio(String runSocio) {
        return lecturaRepo.findByRunSocio(runSocio);
    }

    public Lectura guardarLectura(Lectura lectura) {
        return lecturaRepo.save(lectura);
    }

    public Lectura obtenerUltimaLectura(String runSocio) {
        return lecturaRepo.findTopByRunSocioOrderByFechaLecturaDesc(runSocio)
                .orElse(null); 
    }
}