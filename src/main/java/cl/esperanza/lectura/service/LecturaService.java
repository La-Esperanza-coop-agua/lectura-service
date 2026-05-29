package cl.esperanza.lectura.service;

import org.springframework.stereotype.Service;
import cl.esperanza.lectura.model.Lectura;
import cl.esperanza.lectura.repository.LecturaRepository;
import java.util.List;

@Service
public class LecturaService {

    private final LecturaRepository lecturaRepository;

    public LecturaService(LecturaRepository lecturaRepo) {
        this.lecturaRepository = lecturaRepo;
    }

    public Lectura registrarLectura(Lectura lectura) {
        if (lectura.getLecturaActualM3() < lectura.getLecturaAnteriorM3()) {
            throw new IllegalArgumentException("La lectura actual no puede ser menor a la lectura anterior");
        }

        double totalConsumido = lectura.getLecturaActualM3() - lectura.getLecturaAnteriorM3();
        lectura.setMetrosCubicosConsumidos(totalConsumido);

        return lecturaRepository.save(lectura);
    }
    
    public List<Lectura> obtenerLecturasPorSocio(String run) {
        return lecturaRepository.findByRunSocio(run);
    }
}