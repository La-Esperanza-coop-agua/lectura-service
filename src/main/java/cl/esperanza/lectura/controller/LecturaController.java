package cl.esperanza.lectura.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cl.esperanza.lectura.model.Lectura;
import cl.esperanza.lectura.service.LecturaService;
import cl.esperanza.lectura.dto.CreateLecturaRequest;
import java.util.List;

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

    @PostMapping("/registrar")
    public ResponseEntity<Lectura> registrarNuevaLectura(@Valid @RequestBody CreateLecturaRequest request) {
        Lectura nuevaLectura = lecturaService.registrarLectura(request.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaLectura);
    }
}