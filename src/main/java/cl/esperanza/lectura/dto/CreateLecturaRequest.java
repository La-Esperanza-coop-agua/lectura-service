package cl.esperanza.lectura.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record CreateLecturaRequest(
    @NotBlank(message = "El RUN del socio es obligatorio") String runSocio,
    @NotNull(message = "La fecha no puede estar vacia") LocalDate fechaLectura,
    @PositiveOrZero(message = "La medida del medidor no puede ser negativa") double medidaActual,
    @PositiveOrZero(message = "El consumo mensual no debe estar vacio") double consumoMensual,
    @NotBlank(message = "El periodo es obligatorio") String periodo // <--- Agregamos esta línea
) {}