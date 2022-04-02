package com.samgreen.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.samgreen.dojosandninjas.models.Dojo;
import com.samgreen.dojosandninjas.repositories.DojoRepository;

@Service


public class DojoService {
	private final DojoRepository repo;
	
	public DojoService(DojoRepository repo) {
		this.repo = repo;

}
	
	public List<Dojo> all() {
		return repo.findAll();
	}
	
	

	public Dojo create(Dojo dojo) {
		return repo.save(dojo);
	}
	
	public Dojo update(Dojo dojo) {
		return repo.save(dojo);
	}
	public Dojo find(Long id) {
		Optional<Dojo> optionalDojo = repo.findById(id);
		if(optionalDojo.isPresent() ) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
	public DojoRepository getRepo() {
		return repo;

	}
	public DojoRepository getrepo() {
		return repo;
	}
}
