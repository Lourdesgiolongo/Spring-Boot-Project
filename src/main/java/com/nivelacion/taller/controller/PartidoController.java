package com.nivelacion.taller.controller;

import com.nivelacion.taller.dtos.PartidoDTO;
import com.nivelacion.taller.exceptions.EmptyListException;
import com.nivelacion.taller.exceptions.ModelNotFoundException;
import com.nivelacion.taller.services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<PartidoDTO> getPartidos() throws EmptyListException {
        return partidoService.getPartidos();
    }

    @PostMapping
    public PartidoDTO crearPartido(@Valid @RequestBody PartidoDTO partidoDTO) throws ModelNotFoundException {
        return partidoService.save(partidoDTO);
    }

}
