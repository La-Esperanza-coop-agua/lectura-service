package cl.esperanza.lectura.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.esperanza.lectura.dto.LecturaDTO;
import cl.esperanza.lectura.exception.LecturaInvalidaException;
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
    public Lecturas guardarLectura(LecturaDTO dto) {

        // VALIDACION
        if(dto.getLecturaActual()
            < dto.getLecturaAnterior()) {

            throw new LecturaInvalidaException(
                "La lectura actual no puede ser menor a la anterior");
        }

        // CALCULO DEL CONSUMO
        double consumo =
                dto.getLecturaActual()
              - dto.getLecturaAnterior();

        // CREAR OBJETO
        Lecturas lectura = new Lecturas();

        lectura.setSocioId(dto.getSocioId());

        lectura.setLecturaAnterior(
                dto.getLecturaAnterior());

        lectura.setLecturaActual(
                dto.getLecturaActual());

        lectura.setConsumoMensual(consumo);

        lectura.setFechaLectura(LocalDate.now());

        // GUARDAR EN BASE DE DATOS
        return repository.save(lectura);
    }
}