package com.nivelacion.taller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nivelacion.taller.models.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    boolean existsByNombre(String nombre);

}