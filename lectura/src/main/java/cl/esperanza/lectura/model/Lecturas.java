package cl.esperanza.lectura.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lecturas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Lecturas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int socioId;

    private double lecturaAnterior;

    private double lecturaActual;

    private double consumoMensual;

    private LocalDate fechaLectura;


    
}
