package com.nivelacion.taller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nivelacion.taller.dtos.ParticipanteDTO;
import com.nivelacion.taller.dtos.PartidoDTO;
import com.nivelacion.taller.exceptions.EmptyListException;
import com.nivelacion.taller.services.impl.ParticipanteServiceImpl;
import com.nivelacion.taller.services.ParticipanteService;


import lombok.RequiredArgsConstructor;

@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1")
@CrossOrigin
public class ParticipanteController {

    @Autowired
    private ParticipanteServiceImpl participanteServiceImpl;

    // nuevo
    @Autowired
    private ParticipanteService participanteService;

    @GetMapping("/participantes")
    public ResponseEntity<List<ParticipanteDTO>> getParticipantes() {
        try {
            List<ParticipanteDTO> participanteDTO = participanteServiceImpl.getParticipantes();
            return ResponseEntity.ok().body(participanteDTO);
        } catch (EmptyListException e) {
            return ResponseEntity.noContent().build(); // Devuelve código 204 si la lista está vacía
        }
    }

    // NUEVOS
    @PostMapping ("/participante/save")
    public ResponseEntity<ParticipanteDTO> createParticipante(@RequestBody ParticipanteDTO participanteDTO) {
        ParticipanteDTO createdParticipanteDTO = participanteService.createParticipante(participanteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParticipanteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipanteDTO> updateParticipante(@PathVariable("id") Long id, @RequestBody ParticipanteDTO participanteDTO) {
        ParticipanteDTO updatedParticipanteDTO = participanteService.updateParticipante(id, participanteDTO);
        return ResponseEntity.ok().body(updatedParticipanteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipante(@PathVariable("id") Long id) {
        participanteService.deleteParticipante(id);
        return ResponseEntity.noContent().build();
    }

}