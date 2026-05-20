package cl.esperanza.lectura.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.esperanza.lectura.model.Lecturas;
import cl.esperanza.lectura.repository.LecturaRepository;

@Service
public class LecturaService {

    @Autowired
    private LecturaRepository repository;

    // LISTAR LECTURAS
    public List<Lecturas> obtenerLecturas() {
        return repository.findAll();
    }

    // GUARDAR LECTURA
    public Lecturas guardarLectura(Lecturas lectura) {

        // CALCULO DEL CONSUMO
        double consumo =
                lectura.getLecturaActual()
              - lectura.getLecturaAnterior();

        // GUARDAR CONSUMO
        lectura.setConsumoMensual(consumo);

        // FECHA AUTOMATICA
        lectura.setFechaLectura(LocalDate.now());

        // GUARDAR EN BASE DE DATOS
        return repository.save(lectura);
    }
}