package com.nivelacion.taller.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nivelacion.taller.dtos.ClasificacionDTO;
import com.nivelacion.taller.exceptions.EmptyListException;
import com.nivelacion.taller.exceptions.ModelNotFoundException;
import com.nivelacion.taller.mappers.ClasificacionMapper;
import com.nivelacion.taller.models.Clasificacion;
import com.nivelacion.taller.repository.ClasificacionRepository;
import com.nivelacion.taller.services.ClasificacionService;

@Service
public class ClasificacionServicesImpl implements ClasificacionService {

    @Autowired
    private ClasificacionRepository clasificacionRepository;

    @Autowired
    private ClasificacionMapper clasificacionMapper;

    @Override
    public List<ClasificacionDTO> getClasificaciones() throws EmptyListException {
        List<Clasificacion> modelList = clasificacionRepository.findAll();
        if (modelList.isEmpty()) {
            throw new EmptyListException("Lista de clasificaciones vacía");
        }
        return clasificacionMapper.entityListToDTOList(modelList);
    }

    @Override
    public ClasificacionDTO save(ClasificacionDTO dto) throws ModelNotFoundException {
        Clasificacion clasificacion = clasificacionMapper.dtoToEntity(dto);
        Clasificacion savedClasificacion = clasificacionRepository.save(clasificacion);
        return clasificacionMapper.entityToDto(savedClasificacion);
    }

    @Override
    public ClasificacionDTO updateClasificacion(Long id, ClasificacionDTO clasificacionDTO) throws ModelNotFoundException {
        Optional<Clasificacion> optionalClasificacion = clasificacionRepository.findById(id);
        if (optionalClasificacion.isPresent()) {
            Clasificacion existingClasificacion = optionalClasificacion.get();
            clasificacionMapper.updateEntityFromDTO(existingClasificacion, clasificacionDTO); // Agregar este método al ClasificacionMapper
            Clasificacion updatedClasificacion = clasificacionRepository.save(existingClasificacion);
            return clasificacionMapper.entityToDto(updatedClasificacion);
        } else {
            throw new ModelNotFoundException(id, "Clasificacion");
        }
    }

    @Override
    public void deleteClasificacion(Long id) throws ModelNotFoundException {
        Optional<Clasificacion> optionalClasificacion = clasificacionRepository.findById(id);
        if (optionalClasificacion.isPresent()) {
            clasificacionRepository.deleteById(id);
        } else {
            throw new ModelNotFoundException(id, "Clasificacion");
        }
    }

    @Override
    public List<ClasificacionDTO> getAllClasificaciones() throws EmptyListException {
        List<Clasificacion> modelList = clasificacionRepository.findAll();
        if (modelList.isEmpty()) {
            throw new EmptyListException("Lista de clasificaciones vacía");
        }
        return clasificacionMapper.entityListToDTOList(modelList);
    }

    @Override
    public ClasificacionDTO getClasificacionById(Long id) throws ModelNotFoundException {
        Optional<Clasificacion> optionalClasificacion = clasificacionRepository.findById(id);
        if (optionalClasificacion.isPresent()) {
            return clasificacionMapper.entityToDto(optionalClasificacion.get());
        } else {
            throw new ModelNotFoundException(id, "Clasificacion");
        }
    }

    @Override
public ClasificacionDTO createClasificacion(ClasificacionDTO clasificacionDTO) {
    // Convertir ClasificacionDTO a Clasificacion
    Clasificacion clasificacion = clasificacionMapper.dtoToEntity(clasificacionDTO);
    
    // Guardar la nueva clasificación en la base de datos
    Clasificacion savedClasificacion = clasificacionRepository.save(clasificacion);
    
    // Convertir la clasificación guardada en ClasificacionDTO
    ClasificacionDTO savedClasificacionDTO = clasificacionMapper.entityToDto(savedClasificacion);
    
    // Devolver el ClasificacionDTO creado
    return savedClasificacionDTO;
}

    // Otros métodos omitidos por brevedad...
}
