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
public class DatosBancarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_matriculado", nullable = false)
    private Integer idProfessional;

    @Column(nullable = false, length = 45)
    private String cuil;

    @Column(length = 22)
    private String cbu1;

    @Column(length = 22)
    private String cbu2;

    @Column(length = 22)
    private String cbu3;

    public DatosBancarios() {
    }

    public DatosBancarios(Integer id, Integer idProfessional, String cuil, String cbu1, String cbu2, String cbu3) {
        this.id = id;
        this.idProfessional = idProfessional;
        this.cuil = cuil;
        this.cbu1 = cbu1;
        this.cbu2 = cbu2;
        this.cbu3 = cbu3;
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

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getCbu1() {
        return cbu1;
    }

    public void setCbu1(String cbu1) {
        this.cbu1 = cbu1;
    }

    public String getCbu2() {
        return cbu2;
    }

    public void setCbu2(String cbu2) {
        this.cbu2 = cbu2;
    }

    public String getCbu3() {
        return cbu3;
    }

    public void setCbu3(String cbu3) {
        this.cbu3 = cbu3;
    }

}
