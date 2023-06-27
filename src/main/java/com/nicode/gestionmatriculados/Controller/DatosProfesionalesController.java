/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicode.gestionmatriculados.Controller;

import com.nicode.gestionmatriculados.Model.DatosProfesionales;
import com.nicode.gestionmatriculados.Model.Matriculado;
import com.nicode.gestionmatriculados.Service.DatosProfesionalesService;
import com.nicode.gestionmatriculados.Service.MatriculadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nico
 */
@Controller
public class DatosProfesionalesController {

    @Autowired
    private DatosProfesionalesService datosProfesionalesService;

    @Autowired
    private MatriculadoService matriculadoService;

    @RequestMapping("/newProfessionalData/{id}")
    public String newProfessionalData(Model model, @PathVariable(name = "id") Integer id) {
        DatosProfesionales datosProfesionales = new DatosProfesionales();
        Matriculado matriculado = matriculadoService.getById(id);

        model.addAttribute("matriculado", matriculado);
        model.addAttribute("datosProfesionales", datosProfesionales);

        return "new_dp";
    }

    @RequestMapping(value = "/saveDP", method = RequestMethod.POST)
    public String saveProfesionalData(@ModelAttribute("datosProfesionales") DatosProfesionales datosProfesionales) {
        datosProfesionalesService.save(datosProfesionales);

        return "redirect:/";
    }

    @RequestMapping("/editPD/{id}")
    public ModelAndView editMatriculado(@PathVariable(name = "id") Integer id) {
        ModelAndView model = new ModelAndView("edit_dp");
        DatosProfesionales datosProfesionales = datosProfesionalesService.getById(id);
        model.addObject("datosProfesionales", datosProfesionales);

        return model;
    }
    
    @RequestMapping("/delDP/{id}")
    public String deleteDatosProfesionales(@PathVariable(name = "id") Integer id){
        datosProfesionalesService.deleteById(id);
        return "redirect:/";
    }

}
