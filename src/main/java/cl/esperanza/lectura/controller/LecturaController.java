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
import cl.esperanza.lectura.exception.ResourceNotFoundException;
import cl.esperanza.lectura.mapper.LecturaMapper;
import cl.esperanza.lectura.model.Lectura;
import cl.esperanza.lectura.service.LecturaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/lecturas")
public class LecturaController {
    
    private final LecturaService lecturaService;

    public LecturaController(LecturaService lecServ){
        this.lecturaService = lecServ;
    }

    @GetMapping("/socio/{runSocio}")
    public ResponseEntity<List<Lectura>> getLecturasPorSocio(@PathVariable String runSocio) {
        List<Lectura> registros = lecturaService.obtenerPorSocio(runSocio);
        if (registros.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron lecturas registradas para el socio con RUN: " + runSocio);
        }
        return ResponseEntity.ok(registros);
    }
    @PostMapping
    public ResponseEntity<Lectura> addLectura(@Valid @RequestBody CreateLecturaRequest request){
        Lectura nuevaLectura = lecturaService.guardarLectura(LecturaMapper.toModel(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaLectura);
    }

    @GetMapping("/socio/{runSocio}/ultima")
    public ResponseEntity<Lectura> getUltimaLectura(@PathVariable String runSocio) {
        Lectura ultimaLectura = lecturaService.obtenerUltimaLectura(runSocio);
        if (ultimaLectura == null) {
            throw new ResourceNotFoundException("No se encontraron lecturas registradas con el RUN: " + runSocio);
        }
        return ResponseEntity.ok(ultimaLectura);
    }
}