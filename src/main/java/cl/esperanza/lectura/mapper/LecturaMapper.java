package cl.esperanza.lectura.mapper;

import cl.esperanza.lectura.dto.CreateLecturaRequest;
import cl.esperanza.lectura.model.Lectura;
import java.time.LocalDate;

public class LecturaMapper {
    public static Lectura toModel(CreateLecturaRequest request) {
        return new Lectura(
            null,
            request.runSocio(),
            LocalDate.now(),
            request.medidaActual(),
            0.0
        );
    }
}