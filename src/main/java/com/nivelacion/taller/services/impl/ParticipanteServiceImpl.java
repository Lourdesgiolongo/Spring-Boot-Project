package com.nivelacion.taller.services.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nivelacion.taller.dtos.ParticipanteDTO;
import com.nivelacion.taller.exceptions.EmptyListException;
import com.nivelacion.taller.mappers.ParticipanteMapper;
import com.nivelacion.taller.models.Participante;
import com.nivelacion.taller.repository.ParticipanteRepository;
import com.nivelacion.taller.services.ParticipanteService;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ParticipanteServiceImpl implements ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private ParticipanteMapper participanteMapper;

    @Override
    public List<ParticipanteDTO> getParticipantes() throws EmptyListException {
        List<Participante> modelList = participanteRepository.findAll();
        if (modelList == null || modelList.isEmpty()) {
            throw new EmptyListException("Lista de participantes vacía");
        }

        return participanteMapper.modelToDTO(modelList);
    }

    // NUEVOS
    @Override
    public ParticipanteDTO createParticipante(ParticipanteDTO participanteDTO) {
    // Verificar si ya existe un participante con el mismo nombre
    if (participanteRepository.existsByNombre(participanteDTO.getNombre())) {
        throw new EntityExistsException("Ya existe un participante con el mismo nombre");
    }

    // Si no existe, crear el nuevo participante
    Participante participante = participanteMapper.dtoToModel(participanteDTO);
    try {
        Participante savedParticipante = participanteRepository.save(participante);
        return participanteMapper.modelToDTO(savedParticipante);
    } catch (DataIntegrityViolationException ex) {
        // Manejar la excepción de violación de integridad de datos si ocurre
        throw new RuntimeException("Error al crear el participante", ex);
    }
}


    @Override
    public ParticipanteDTO updateParticipante(Long id, ParticipanteDTO participanteDTO) {
        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participante not found with id: " + id));
        participante.setNombre(participanteDTO.getNombre());
        participante.setColores(participanteDTO.getColores());
        participante.setTrofeos(participanteDTO.getTrofeos());
        participante.setFecha_baja(participanteDTO.getFecha_baja()); // Corrección aquí
        Participante updatedParticipante = participanteRepository.save(participante);
        return participanteMapper.modelToDTO(updatedParticipante);
    }
    
    @Override
    public void deleteParticipante(Long id) throws EntityNotFoundException {
        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participante not found with id: " + id));
        participanteRepository.delete(participante);
    }
}