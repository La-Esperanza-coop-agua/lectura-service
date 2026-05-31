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

    @Column(nullable = false, length = 13)
    private String runSocio;

    @Column(nullable = false)
    private LocalDate fechaLectura;

    @Column(nullable = false)
    private double medidaActual;

    @Column(nullable = false)
    private double consumoMensual;
}