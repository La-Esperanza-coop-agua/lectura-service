package cl.esperanza.lectura.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.esperanza.lectura.dto.CreateLecturaRequest;
import cl.esperanza.lectura.exception.ResourceNotFoundException;
import cl.esperanza.lectura.mapper.LecturaMapper;
import cl.esperanza.lectura.model.Lectura;
import cl.esperanza.lectura.service.LecturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/lecturas")
public class LecturaController {
    
    private final LecturaService lecturaService;

    public LecturaController(LecturaService lecServ){
        this.lecturaService = lecServ;
    }

    @Operation(summary = "Historial de lecturas por socio", description = "Obtiene todas las lecturas asociadas al RUN de un socio")
    @ApiResponse(responseCode = "200", description = "Lista de lecturas retornada")
    @GetMapping("/socio/{runSocio}")
    public ResponseEntity<List<Lectura>> getLecturasPorSocio(@PathVariable String runSocio) {
        List<Lectura> registros = lecturaService.obtenerPorSocio(runSocio);
        if (registros.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron lecturas registradas para el RUN del socio: " + runSocio);
        }
        return ResponseEntity.ok(registros);
    }

    @Operation(summary = "Registrar una nueva lectura", description = "Guarda el registro del medidor de agua para un socio en un periodo específico")
    @ApiResponse(responseCode = "201", description = "Lectura registrada exitosamente")
    @PostMapping
    public ResponseEntity<Lectura> addLectura(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Estructura JSON requerida para ingresar una lectura de consumo",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = CreateLecturaRequest.class),
                examples = @ExampleObject(
                    name = "Ejemplo Registro Mensual",
                    value = "{\"runSocio\": \"12445578-9\", \"consumoMensual\": 15.5, \"periodo\": \"2026-10\"}"
                )
            )
        )
        @Valid @org.springframework.web.bind.annotation.RequestBody CreateLecturaRequest request){
        
        Lectura nuevaLectura = lecturaService.guardarLectura(LecturaMapper.toModel(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaLectura);
    }

    @Operation(summary = "Obtener última lectura", description = "Obtiene el registro de consumo más reciente de un socio para la facturación")
    @ApiResponse(responseCode = "200", description = "Última lectura retornada con éxito")
    @GetMapping("/socio/{runSocio}/ultima")
    public ResponseEntity<Lectura> getUltimaLectura(@PathVariable String runSocio) {
        Lectura ultimaLectura = lecturaService.obtenerUltimaLectura(runSocio);
        if (ultimaLectura == null) {
            throw new ResourceNotFoundException("No se encontraron lecturas registradas con el RUN: " + runSocio);
        }
        return ResponseEntity.ok(ultimaLectura);
    }
}