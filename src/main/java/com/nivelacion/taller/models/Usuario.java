package com.nivelacion.taller.models;

import java.util.Collection;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.nivelacion.taller.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Marca la clase como una entidad JPA, que significa que representa una tabla en la bd
@Entity

// Anotacion de lombok que genera automaticamente metodos como getters y setters
@Data

// Anotaciones lombok que generan automaticamente un constructor sin argumentos, y un constructor que incluye todos los campos de la clase como argumentos.
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "mail")
    private String mail;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Transient
    private Collection<Role> roles = new ArrayList<>();
    
    public Collection<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
