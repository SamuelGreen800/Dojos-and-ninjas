package com.samgreen.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.samgreen.dojosandninjas.models.Ninja;
import com.samgreen.dojosandninjas.services.DojoService;
import com.samgreen.dojosandninjas.services.NinjaService;

@Controller

public class NinjaController {
	
	@Autowired 
	private DojoService dojoService;
	
	@Autowired 
	private NinjaService ninjaService;
	
	
	

	@GetMapping("/ninjas")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.all());
		return "addNinja.jsp";
		
	}
	
	
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, RedirectAttributes redirectAttrs, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoService.all());
			return "addNinja.jsp";
		}
		
		ninjaService.create(ninja);
		redirectAttrs.addAttribute("dojo", ninja.getDojo());
		return "redirect:/dojos/{dojo}";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		//redirectAttrs.addAttribute("dojo", ninja.getDojo());
		ninjaService.delete(id);
		return "redirect:/dojos/{id}";
	}
	
	
	
	
	
	
	
	
	
	//==========================================================================Getters/Setters============================================================

	public DojoService getDojoService() {
		return dojoService;
	}

	public void setDojoService(DojoService dojoService) {
		this.dojoService = dojoService;
	}

	public NinjaService getNinjaService() {
		return ninjaService;
	}

	public void setNinjaService(NinjaService ninjaService) {
		this.ninjaService = ninjaService;
	}
	
	

}
