
package com.nicode.gestionmatriculados.Repository;

import com.nicode.gestionmatriculados.Model.Matriculado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MatriculadoRepository extends JpaRepository<Matriculado, Integer>{
    
    @Query("SELECT p FROM Matriculado p WHERE p.name LIKE %?1%"
            + " OR p.surname LIKE %?1%"
            + " OR p.schedule LIKE %?1%")
    public List<Matriculado> findAll(@Param("1") String keyword);
    
}
