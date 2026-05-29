package cl.esperanza.lectura.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import cl.esperanza.lectura.model.Lectura;

public record CreateLecturaRequest(
    @NotBlank(message = "El RUN es obligatorio")
    String runSocio,

    @NotBlank(message = "El periodo es obligatorio (Ej: 2026-05)")
    String periodo,

    @PositiveOrZero(message = "La lectura anterior no puede ser negativa")
    double lecturaAnteriorM3,

    @PositiveOrZero(message = "La lectura actual no puede ser negativa")
    double lecturaActualM3
) {
    public Lectura toEntity() {
        Lectura lectura = new Lectura();
        lectura.setRunSocio(this.runSocio());
        lectura.setPeriodo(this.periodo());
        lectura.setLecturaAnteriorM3(this.lecturaAnteriorM3());
        lectura.setLecturaActualM3(this.lecturaActualM3());
        return lectura;
    }
}