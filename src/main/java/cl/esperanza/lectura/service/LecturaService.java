package cl.esperanza.lectura.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.esperanza.lectura.model.Lectura;
import cl.esperanza.lectura.repository.LecturaRepository;

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

    public Lectura obtenerLecturaExacta(String run, String periodo){
        return lecturaRepository.findByRunSocioAndPeriodo(run, periodo)
        .orElseThrow(() -> new RuntimeException("No se encontró una lectura para el socio "+ run +" en el periodo"+ periodo));
    }
}