package com.nivelacion.taller.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PartidoDTO {

    private Long id;

    @NotNull(message = "Ingrese el ID del equipo local")
    @Size(min = 1)
    private Long idLocal;

    @NotNull(message = "Ingrese el ID del equipo visitante")
    @Size(min = 1)
    private Long idVisitante;

    @NotNull(message = "Ingrese el ID de la competencia")
    @Size(min = 1)
    private Long idCompetencia;

    @NotNull(message = "Ingrese los goles del equipo local")
    @Size(min = 1)
    private Integer golesLocal;

    @NotNull(message = "Ingrese los goles del equipo visitante")
    @Size(min = 1)
    private Integer golesVisitante;

    @NotNull(message = "Ingrese la fecha de realización del partido")
    private LocalDateTime fechaRealizacion;

    @NotNull(message = "Ingrese una fecha de baja")
    private LocalDateTime fechaBaja;

    // Getters y setters generados automáticamente

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public Long getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Long idVisitante) {
        this.idVisitante = idVisitante;
    }

    public Long getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Long idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public LocalDateTime getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDateTime fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public LocalDateTime getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
}
