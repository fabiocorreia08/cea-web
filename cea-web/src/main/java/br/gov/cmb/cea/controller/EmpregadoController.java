package br.gov.cmb.cea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.gov.cmb.cea.model.Empregado;
import br.gov.cmb.cea.service.EmpregadoService;



@Controller
@RequestMapping(value="/empregado")
public class EmpregadoController {
	
	@Autowired
	EmpregadoService empregadoService;
		
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("empregado_erp_list");
		List<Empregado> empregadoList = empregadoService.getAll();
		model.addObject("empregadoList", empregadoList);
		return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("empregado_erp_list");		
		Empregado empregado = new Empregado();
		model.addObject("empregadoForm", empregado);
		model.setViewName("empregado_erp_form");		
		return model;
	}	
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable long id) {
		ModelAndView model = new ModelAndView("empregado_erp_list");		
		Empregado empregado = empregadoService.getById(id);
		model.addObject("empregadoForm", empregado);
		model.setViewName("empregado_erp_form");		
		return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("empregadoForm") Empregado empregado) {			
		empregadoService.saveOrUpdate(empregado);		
		return new ModelAndView("redirect:/empregado/list");
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {			
		empregadoService.delete(id);		
		return new ModelAndView("redirect:/empregado/list");
	}
	

}
