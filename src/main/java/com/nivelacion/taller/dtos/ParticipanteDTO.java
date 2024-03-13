package com.nivelacion.taller.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ParticipanteDTO {

    private Long id;

    @NotNull(message = "Ingrese un nombre")
    @Size(min = 1)
    private String nombre;

    @NotNull(message = "Ingrese sus colores")
    private String colores;

    @NotNull(message = "Ingrese sus trofeos")
    private String trofeos;

    @NotNull(message = "Ingrese una fecha de baja")
    private LocalDateTime fecha_baja;

    private UsuarioDTO usuario;

    public ParticipanteDTO() {
    }

    public ParticipanteDTO(Long id, @NotNull(message = "Ingrese un nombre") @Size(min = 1) String nombre,
            @NotNull(message = "Ingrese sus colores") @Size(min = 1) String colores,
            @NotNull(message = "Ingrese sus trofeos") @Size(min = 1) String trofeos, @NotNull(message = "Ingrese una fecha de baja") LocalDateTime fecha_baja, UsuarioDTO usuario) {
        this.id = id;
        this.nombre = nombre;
        this.colores = colores;
        this.trofeos = trofeos;
        this.fecha_baja = fecha_baja;
        this.usuario = usuario;
    }
    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    public String getTrofeos() {
        return trofeos;
    }

    public void setTrofeos(String trofeos) {
        this.trofeos = trofeos;
    }
    

    public LocalDateTime getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(LocalDateTime fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    
}