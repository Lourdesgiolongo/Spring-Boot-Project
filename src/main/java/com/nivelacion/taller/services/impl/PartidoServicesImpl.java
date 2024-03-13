package com.nivelacion.taller.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nivelacion.taller.dtos.PartidoDTO;
import com.nivelacion.taller.exceptions.EmptyListException;
import com.nivelacion.taller.exceptions.ModelNotFoundException;
import com.nivelacion.taller.mappers.PartidoMapper;
import com.nivelacion.taller.models.Partido;
import com.nivelacion.taller.repository.PartidoRepository;
import com.nivelacion.taller.services.PartidoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PartidoServicesImpl implements PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    @Autowired
    private PartidoMapper partidoMapper;

    @Override
    public List<PartidoDTO> getPartidos() throws EmptyListException {
        List<Partido> modelList = partidoRepository.findAll();
        if (modelList == null || modelList.isEmpty()) {
            throw new EmptyListException("Lista de partidos vacía");
        }

        return partidoMapper.modelToDTO(modelList);
    }

    @Override
    public PartidoDTO save(PartidoDTO dto) throws ModelNotFoundException {
        // Implementa la lógica para guardar un partido
        return null;
    }

    // Agrega otros métodos según sea necesario

}
