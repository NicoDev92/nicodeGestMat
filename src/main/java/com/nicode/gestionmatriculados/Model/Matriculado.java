
package com.nicode.gestionmatriculados.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class Matriculado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 75)
    private String name;

    @Column(name = "apellido", nullable = false, length = 75)
    private String surname;

    @Column(nullable = false, length = 10)
    private String dni;

    @Column(name = "matricula", nullable = false, length = 45)
    private String schedule;
    
    @Column(name = "direccion", length = 245)
    private String adress;
    
    @OneToOne
    @JoinColumn(name ="id")
    private DatosProfesionales professionalData;

    @OneToOne
    @JoinColumn(name ="id")   
    private DatosBancarios bankData;

    public Matriculado() {
    }

    
    public Matriculado(Integer id, String name, String surname, String dni, String schedule) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.schedule = schedule;
    }

    public Matriculado(Integer id, String name, String surname, String dni, String schedule, String adress, DatosProfesionales professionalData, DatosBancarios bankData) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.schedule = schedule;
        this.adress = adress;
        this.professionalData = professionalData;
        this.bankData = bankData;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    public DatosProfesionales getProfessionalData() {
        return professionalData;
    }

    public void setProfessionalData(DatosProfesionales professionalData) {
        this.professionalData = professionalData;
    }

    public DatosBancarios getBankData() {
        return bankData;
    }

    public void setBankData(DatosBancarios bankData) {
        this.bankData = bankData;
    }
}
