package com.nivelacion.taller.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nivelacion.taller.dtos.ParticipanteDTO;
import com.nivelacion.taller.enums.Estado;
import com.nivelacion.taller.exceptions.EmptyListException;
import com.nivelacion.taller.exceptions.ModelNotFoundException;
import com.nivelacion.taller.mappers.ParticipanteMapper;
import com.nivelacion.taller.models.Participante;
import com.nivelacion.taller.models.Usuario;
import com.nivelacion.taller.repository.ParticipanteRepository;
import com.nivelacion.taller.repository.UsuarioRepository;
import com.nivelacion.taller.services.ParticipanteService;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;


@Service
@Slf4j
public class ParticipanteServicesImpl implements ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ParticipanteMapper participanteMapper;

    @Override
    public List<ParticipanteDTO> getParticipantes() throws EmptyListException {
        List<Participante> modelList = 
        participanteRepository.findAll();
        if (modelList == null || modelList.isEmpty()) {
            throw new EmptyListException("Lista de participantes vacía");
        }

        return participanteMapper.modelToDTO(modelList);
    }

    @Override
    public ParticipanteDTO save(ParticipanteDTO dto) throws ModelNotFoundException {
        // Verificar si el usuario asociado al participante existe
        Long usuarioId = dto.getUsuario().getId();
        Usuario usuario = usuarioRepository.findById(usuarioId)
        .orElseThrow(() -> new ModelNotFoundException(usuarioId, "Usuario"));


        // Si tiene un ID, buscar el participante en la base de datos
        Participante model = null;
        if (dto.getId() != null && dto.getId() != 0) {
            model = participanteRepository.findById(dto.getId()).orElse(null);
            if (model == null) {
                throw new ModelNotFoundException(dto.getId(), "Participante");
            }
        }
        // Mapear DTO a modelo
        model = participanteMapper.dto2Model(dto);

        //Asignar el usuario al modelo de participante 
        model.setUsuario(usuario);

        // Guardar el participante en la base de datos
        Participante modelSaved = participanteRepository.save(model);

        // Mapear modelo a DTO
        ParticipanteDTO result = participanteMapper.original2DTO(modelSaved);

        return result;
    }

}
