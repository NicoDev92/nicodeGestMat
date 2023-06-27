/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicode.gestionmatriculados.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author Nico
 */
@Entity
public class DatosProfesionales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_matriculado", nullable = false)
    private Integer idProfessional;

    @Column(name = "profesion", nullable = false, length = 125)
    private String profession;

    @Column(name = "fecha_matriculacion", nullable = false, length = 45)
    private String registrationDate;

    @Column(name = "estado", nullable = false, length = 45)
    private String state;

    public DatosProfesionales() {
    }

    public DatosProfesionales(Integer id, Integer idProfessional, String profession, String registrationDate, String state) {
        this.id = id;
        this.idProfessional = idProfessional;
        this.profession = profession;
        this.registrationDate = registrationDate;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProfessional() {
        return idProfessional;
    }

    public void setIdProfessional(Integer idProfessional) {
        this.idProfessional = idProfessional;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
