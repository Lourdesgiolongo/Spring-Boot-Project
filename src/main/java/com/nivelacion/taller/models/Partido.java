package com.nivelacion.taller.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "partido")
public class Partido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "goles_local", nullable = false)
    private Integer golesLocal;

    @Column(name = "goles_visitante", nullable = false)
    private Integer golesVisitante;

    @Column(name = "fecha_realizacion", nullable = false)
    private LocalDateTime fechaRealizacion;

    @Column(name = "fecha_baja")
    private LocalDateTime fechaBaja;

    @ManyToOne
    @JoinColumn(name = "id_participante_local", referencedColumnName = "id")
    private Participante participanteLocal;

    @ManyToOne
    @JoinColumn(name = "id_participante_visitante", referencedColumnName = "id")
    private Participante participanteVisitante;

    @ManyToOne
    @JoinColumn(name = "id_competencia", referencedColumnName = "id")
    private Competencia competencia;
}
