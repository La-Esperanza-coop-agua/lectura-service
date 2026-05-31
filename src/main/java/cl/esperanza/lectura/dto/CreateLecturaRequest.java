package cl.esperanza.lectura.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record CreateLecturaRequest(
    @NotBlank(message = "El RUN del socio es obligatorio")
    String runSocio,

    @PositiveOrZero(message = "La medida del medidor no puede ser negativa")
    double medidaActual
) {}