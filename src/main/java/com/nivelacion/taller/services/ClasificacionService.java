package com.nivelacion.taller.services;

import java.util.List;

import com.nivelacion.taller.dtos.ClasificacionDTO;
import com.nivelacion.taller.exceptions.EmptyListException;
import com.nivelacion.taller.exceptions.ModelNotFoundException;

public interface ClasificacionService {

    List<ClasificacionDTO> getClasificaciones() throws EmptyListException;

    ClasificacionDTO save(ClasificacionDTO dto) throws ModelNotFoundException;

    ClasificacionDTO updateClasificacion(Long id, ClasificacionDTO clasificacionDTO) throws ModelNotFoundException;

    void deleteClasificacion(Long id) throws ModelNotFoundException;

    List<ClasificacionDTO> getAllClasificaciones() throws EmptyListException;

    ClasificacionDTO getClasificacionById(Long id) throws ModelNotFoundException;

    ClasificacionDTO createClasificacion(ClasificacionDTO clasificacionDTO);
}
