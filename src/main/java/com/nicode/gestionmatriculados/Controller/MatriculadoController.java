/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicode.gestionmatriculados.Controller;

import com.nicode.gestionmatriculados.Model.DatosBancarios;
import com.nicode.gestionmatriculados.Model.DatosProfesionales;
import com.nicode.gestionmatriculados.Model.Matriculado;
import com.nicode.gestionmatriculados.Service.DatosBancariosService;
import com.nicode.gestionmatriculados.Service.DatosProfesionalesService;
import com.nicode.gestionmatriculados.Service.MatriculadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
public class MatriculadoController {
    
    @Autowired
    private MatriculadoService matriculadoService;
    
    @Autowired
    private DatosBancariosService datosBancariosService;
    
    @Autowired
    private DatosProfesionalesService datosProfesionalesService;
    
    @RequestMapping("/")
    public String homePage(Model model, @Param("keyword") String keyword){
        List<Matriculado> matriculados = matriculadoService.getAll(keyword);
        
        //Se agrega el model para que en el HTML se pueda acceder a la lista y su contenido
        model.addAttribute("matriculados",matriculados);
        model.addAttribute("keyword", keyword);
        
        return "index";
    }
    
    @RequestMapping("/view/{id}")
    public ModelAndView viewMatriculado(@PathVariable(name = "id") Integer id){
        ModelAndView model = new ModelAndView("view_mat");
        
        Matriculado matriculado = matriculadoService.getById(id);
        DatosBancarios datosBancarios = datosBancariosService.findByIdMatriculado(id);
        DatosProfesionales datosProfesionales = datosProfesionalesService.findByIdMatriculado(id);
        
        model.addObject("matriculado", matriculado);
        model.addObject("datosBancarios", datosBancarios);
        model.addObject("datosProfesionales", datosProfesionales);
        
        
        return model;
    }
    
    @RequestMapping("/new")
    public String newRegister(Model model){
        Matriculado matriculado = new Matriculado();
        //Se agrega el model para que en el HTML se pueda acceder a la lista y su contenido
        model.addAttribute("matriculado",matriculado);
        
        return "new_mat";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveMatriculado(@ModelAttribute("matriculado") Matriculado matriculado){
        matriculadoService.save(matriculado);
        
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView editMatriculado(@PathVariable(name = "id") Integer id){
        ModelAndView model = new ModelAndView("edit_mat");
        Matriculado matriculado = matriculadoService.getById(id);
        model.addObject("matriculado",matriculado);
        
        return model;
    }
    
}
