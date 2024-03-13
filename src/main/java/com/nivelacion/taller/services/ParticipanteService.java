package com.nivelacion.taller.services;

import java.util.List;

import com.nivelacion.taller.dtos.ParticipanteDTO;
import com.nivelacion.taller.exceptions.EmptyListException;
import com.nivelacion.taller.exceptions.ModelNotFoundException;

public interface ParticipanteService {

    List<ParticipanteDTO> getParticipantes() throws EmptyListException;

    ParticipanteDTO save(ParticipanteDTO dto) throws ModelNotFoundException;
    
}
