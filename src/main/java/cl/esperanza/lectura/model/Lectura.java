package cl.esperanza.lectura.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lectura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lectura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "run_socio", nullable = false, length = 10)
    private String runSocio;

    @Column(name = "fecha_lectura", nullable = false)
    private LocalDate fechaLectura;

    @Column(name = "medida_actual", nullable = false)
    private double medidaActual;

    @Column(name = "consumo_mensual", nullable = false)
    private double consumoMensual;

    @Column(name = "periodo", nullable = false, length = 7)
    private String periodo;
}