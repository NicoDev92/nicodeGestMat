/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicode.gestionmatriculados.Controller;

import com.nicode.gestionmatriculados.Model.DatosBancarios;
import com.nicode.gestionmatriculados.Model.Matriculado;
import com.nicode.gestionmatriculados.Service.DatosBancariosService;
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
public class DatosBancariosController {

    @Autowired
    private DatosBancariosService datosBancariosService;

    @Autowired
    private MatriculadoService matriculadoService;

    @RequestMapping("/newBankData/{id}")
    public String newBankData(Model model, @PathVariable(name = "id") Integer id) {
        Matriculado matriculado = matriculadoService.getById(id);
        DatosBancarios datosBancarios = new DatosBancarios();
        model.addAttribute("datosBancarios", datosBancarios);
        model.addAttribute("matriculado", matriculado);

        return "new_bankData";
    }

    @RequestMapping(value = "/saveBD", method = RequestMethod.POST)
    public String saveBankData(@ModelAttribute("datosBancarios") DatosBancarios datosBancarios) {
        datosBancariosService.save(datosBancarios);

        return "redirect:/";
    }

    @RequestMapping("/editBD/{id}")
    public ModelAndView editMatriculado(@PathVariable(name = "id") Integer id) {
        ModelAndView model = new ModelAndView("edit_bd");
        DatosBancarios datosBancarios = datosBancariosService.getById(id);
        model.addObject("datosBancarios", datosBancarios);

        return model;
    }

    @RequestMapping("/delDB/{id}")
    public String deleteDatosBancarios(@PathVariable(name = "id") Integer id) {
        datosBancariosService.deleteById(id);
        return "redirect:/";
    }
}
