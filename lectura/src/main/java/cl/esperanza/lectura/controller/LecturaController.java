package cl.esperanza.lectura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.esperanza.lectura.model.Lecturas;
import cl.esperanza.lectura.service.LecturaService;

@RestController
@RequestMapping("/lecturas")

public class LecturaController {

    @Autowired
    private LecturaService service;


    @GetMapping
    public List<Lecturas> listar() {
        return service.obtenerLecturas();
    }

    @PostMapping
    public Lecturas guardar(
            @RequestBody Lecturas lectura) {

        return service.guardarLectura(lectura);
    }
}