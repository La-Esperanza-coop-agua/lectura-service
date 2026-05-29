package cl.esperanza.lectura.model;

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
    private String periodo;

    @Column(nullable = false)
    private double lecturaAnteriorM3;

    @Column(nullable = false)
    private double lecturaActualM3;

    @Column(nullable = false)
    private double metrosCubicosConsumidos; 
}