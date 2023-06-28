
package com.nicode.gestionmatriculados.Service;

import com.nicode.gestionmatriculados.Model.DatosBancarios;
import com.nicode.gestionmatriculados.Repository.DatosBancariosRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DatosBancariosService {

    @Autowired
    private DatosBancariosRepository datosBancariosRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public void save(DatosBancarios datosBancarios) {
        datosBancariosRepository.save(datosBancarios);
    }

    public DatosBancarios getById(Integer id) {
        return datosBancariosRepository.getById(id);
    }

    public void deleteById(Integer id) {
        datosBancariosRepository.deleteById(id);
    }

    public DatosBancarios findByIdMatriculado(Integer idMatriculado) {
        String sql = "SELECT * FROM datos_bancarios WHERE id_matriculado = :idMatriculado";
        Query query = entityManager.createNativeQuery(sql, DatosBancarios.class);
        query.setParameter("idMatriculado", idMatriculado);

        try {
            DatosBancarios datosBancarios = (DatosBancarios) query.getSingleResult();
            return datosBancarios;
        } catch (NoResultException e) {
            return null;
        }
    }

}
