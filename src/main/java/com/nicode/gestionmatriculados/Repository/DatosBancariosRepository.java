/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nicode.gestionmatriculados.Repository;

import com.nicode.gestionmatriculados.Model.DatosBancarios;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nico
 */
public interface DatosBancariosRepository extends JpaRepository<DatosBancarios, Integer> {
    
}
