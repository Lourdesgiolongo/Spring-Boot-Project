package com.nivelacion.taller.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.nivelacion.taller.dtos.ParticipanteDTO;
import com.nivelacion.taller.exceptions.EmptyListException;

public interface ParticipanteService {

    List<ParticipanteDTO> getParticipantes() throws EmptyListException;

    // NUEVOS 
    ParticipanteDTO createParticipante(ParticipanteDTO participanteDTO);
     // NUEVOS 
    ParticipanteDTO updateParticipante(Long id, ParticipanteDTO participanteDTO);
     // NUEVOS 
    void deleteParticipante(Long id) throws EntityNotFoundException;
}