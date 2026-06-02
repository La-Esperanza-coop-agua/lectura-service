package cl.esperanza.lectura.mapper;

import cl.esperanza.lectura.dto.CreateLecturaRequest;
import cl.esperanza.lectura.model.Lectura;

public class LecturaMapper {
    public static Lectura toModel(CreateLecturaRequest request) {
        return new Lectura(null,
            request.runSocio(), request.fechaLectura(), request.medidaActual(),
            request.consumoMensual()
        );
    }
}