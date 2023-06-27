/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicode.gestionmatriculados.Service;

import com.nicode.gestionmatriculados.Model.DatosProfesionales;
import com.nicode.gestionmatriculados.Repository.DatosProfesionalesRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nico
 */
@Service
public class DatosProfesionalesService {

    @Autowired
    private DatosProfesionalesRepository datosProfesionalesRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public void save(DatosProfesionales datosProfesionales) {
        datosProfesionalesRepository.save(datosProfesionales);
    }

    public DatosProfesionales getById(Integer id) {
        return datosProfesionalesRepository.getById(id);
    }

    public void deleteById(Integer id) {
        datosProfesionalesRepository.deleteById(id);
    }

    public DatosProfesionales findByIdMatriculado(Integer idMatriculado) {
        String sql = "SELECT * FROM datos_profesionales WHERE id_matriculado = :idMatriculado";
        Query query = entityManager.createNativeQuery(sql, DatosProfesionales.class);
        query.setParameter("idMatriculado", idMatriculado);

        try {
            DatosProfesionales datosProfesionales = (DatosProfesionales) query.getSingleResult();
            return datosProfesionales;
        } catch (NoResultException e) {
            return null;
        }
    }

}
