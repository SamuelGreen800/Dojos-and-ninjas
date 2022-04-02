package com.samgreen.dojosandninjas.controllers;
import java.util.List;

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

import com.samgreen.dojosandninjas.models.Dojo;
import com.samgreen.dojosandninjas.models.Ninja;
import com.samgreen.dojosandninjas.services.DojoService;
import com.samgreen.dojosandninjas.services.NinjaService;

@Controller

public class DojoController {
	@Autowired 
	private DojoService dojoService;
	
	@Autowired 
	private NinjaService ninjaService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos")
	public String dojos(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> dojos = dojoService.all();
		model.addAttribute("dojos", dojos);
		return "addDojo.jsp";
	}
	
	@GetMapping("/ninjas")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.all());
		return "addNinja.jsp";
		
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		
		Dojo dojo = dojoService.find(id);
		model.addAttribute("dojo", dojo);
		
		return "showDojo.jsp";
	}
	
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> dojos = dojoService.all();
			model.addAttribute("dojos", dojos);
			return "addDojo.jsp";
			
		}
		else {
		dojoService.create(dojo);
		return "redirect:/dojos";}
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
	
	
//	@PostMapping("/ninjas")
//	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			
//			return "addNinja.jsp";
//		}
//		else {
//		ninjaService.create(ninja);
//		return "redirect:/ninjas";
//		
//	}
//	}
//	
	
	
	//++++++++++++++++++++++++++++++++++Get/Set=========================================================
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
