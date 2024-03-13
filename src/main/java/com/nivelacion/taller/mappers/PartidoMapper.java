package com.nivelacion.taller.mappers;

import com.nivelacion.taller.dtos.PartidoDTO;
import com.nivelacion.taller.models.Partido;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PartidoMapper {

    public PartidoDTO entityToDto(Partido partido) {
        PartidoDTO dto = new PartidoDTO();
        // Mapear los campos del partido al DTO
        dto.setId(partido.getId());
        dto.setIdLocal(partido.getParticipanteLocal().getId());
        dto.setIdVisitante(partido.getParticipanteVisitante().getId());
        dto.setIdCompetencia(partido.getCompetencia().getId());
        dto.setGolesLocal(partido.getGolesLocal());
        dto.setGolesVisitante(partido.getGolesVisitante());
        dto.setFechaRealizacion(partido.getFechaRealizacion());
        dto.setFechaBaja(partido.getFechaBaja());
        return dto;
    }

    public Partido dtoToEntity(PartidoDTO dto) {
        Partido partido = new Partido();
        // Mapear los campos del DTO al partido
        partido.setId(dto.getId());
        // Aquí no se asignan los IDs de los participantes y la competencia,
        // ya que no se puede inferir de un DTO.
        partido.setGolesLocal(dto.getGolesLocal());
        partido.setGolesVisitante(dto.getGolesVisitante());
        partido.setFechaRealizacion(dto.getFechaRealizacion());
        partido.setFechaBaja(dto.getFechaBaja());
        return partido;
    }

    public List<PartidoDTO> modelToDTO(List<Partido> partidoList) {
        return partidoList.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
}
