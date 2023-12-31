
package com.nicode.gestionmatriculados.Service;

import com.nicode.gestionmatriculados.Model.Matriculado;
import com.nicode.gestionmatriculados.Repository.MatriculadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculadoService {

    @Autowired
    private MatriculadoRepository matriculadoRepository;

    public List<Matriculado> getAll(String keyword) {
        if (keyword != null) {
            return matriculadoRepository.findAll(keyword);
        }

        return matriculadoRepository.findAll();

    }

    public void save(Matriculado matriculado) {
        matriculadoRepository.save(matriculado);
    }

    public Matriculado getById(Integer id) {
        return matriculadoRepository.getById(id);
    }

    public void deleteById(Integer id) {
        matriculadoRepository.deleteById(id);
    }

}
