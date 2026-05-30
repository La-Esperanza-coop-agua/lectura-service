package cl.esperanza.lectura.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.esperanza.lectura.dto.CreateLecturaRequest;
import cl.esperanza.lectura.model.Lectura;
import cl.esperanza.lectura.service.LecturaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/lectura")
public class LecturaController {
    
    private final LecturaService lecturaService;

    public LecturaController(LecturaService lecturaService) {
        this.lecturaService = lecturaService;
    }

    @GetMapping("/socio/{run}")
    public ResponseEntity<List<Lectura>> getLecturasPorSocio(@PathVariable String run) {
        return ResponseEntity.ok(lecturaService.obtenerLecturasPorSocio(run));
    }

    // Endpoint que usara el micro de facturacion
    @GetMapping("/socio/{run}/periodo/{periodo}")
    public ResponseEntity<Lectura> getLecturaPorPeriodo(@PathVariable String run, @PathVariable String periodo){
        Lectura lectura = lecturaService.obtenerLecturaExacta(run, periodo);
        return ResponseEntity.ok(lectura);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Lectura> registrarNuevaLectura(@Valid @RequestBody CreateLecturaRequest request) {
        Lectura nuevaLectura = lecturaService.registrarLectura(request.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaLectura);
    }
}