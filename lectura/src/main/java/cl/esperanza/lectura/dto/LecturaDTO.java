package cl.esperanza.lectura.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LecturaDTO {

    private int socioId;

    private double lecturaAnterior;

    private double lecturaActual;

}