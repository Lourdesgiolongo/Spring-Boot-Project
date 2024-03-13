package com.nivelacion.taller.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nivelacion.taller.dtos.ParticipanteDTO;

import com.nivelacion.taller.models.Participante;

@Component
public class ParticipanteMapper {
    
    public ParticipanteDTO original2DTO(Participante participante) {
        ParticipanteDTO dtoParticipante = new ParticipanteDTO();
        dtoParticipante.setNombre(participante.getNombre());
        dtoParticipante.setColores(participante.getColores());
        dtoParticipante.setTrofeos(participante.getTrofeos());
        dtoParticipante.setFecha_baja(participante.getFecha_baja());
        dtoParticipante.setUsuario(new UsuarioMapper().originalToDTO(participante.getUsuario()));
        return dtoParticipante;
    }

    public Participante dto2Model(ParticipanteDTO participanteDTO) {
        Participante newParticipante = new Participante();
        newParticipante.setNombre(participanteDTO.getNombre());
        newParticipante.setColores(participanteDTO.getColores());
        newParticipante.setFecha_baja(participanteDTO.getFecha_baja());
        newParticipante.setUsuario(new UsuarioMapper().dto2Model(participanteDTO.getUsuario()));
        return newParticipante;
    }

    public List<ParticipanteDTO> modelToDTO(List<Participante> participantesList) {
        return participantesList.stream()
                .map(this::original2DTO)
                .collect(Collectors.toList());
    }

    public ParticipanteDTO entityToDto(Participante competidor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entityToDto'");
    }

    public Participante dtoToEntity(ParticipanteDTO competidor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dtoToEntity'");
    }
    
}
