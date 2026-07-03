package cl.esperanza.lectura.mapper;

import java.time.LocalDate;
import cl.esperanza.lectura.dto.CreateLecturaRequest;
import cl.esperanza.lectura.model.Lectura;

public class LecturaMapper {
    public static Lectura toModel(CreateLecturaRequest request) {
        Lectura lectura = new Lectura();
        
        lectura.setRunSocio(request.runSocio());
        lectura.setConsumoMensual(request.consumoMensual());
        lectura.setPeriodo(request.periodo());
        
        lectura.setId(null);
        lectura.setFechaLectura(LocalDate.now());
        lectura.setMedidaActual(0.0);
        
        return lectura;
    }
}