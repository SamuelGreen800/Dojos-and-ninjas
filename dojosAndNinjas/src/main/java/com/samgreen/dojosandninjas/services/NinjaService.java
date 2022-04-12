package com.samgreen.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samgreen.dojosandninjas.models.Ninja;
import com.samgreen.dojosandninjas.repositories.NinjaRepository;

	@Service


public class NinjaService {
private final NinjaRepository repo;
		
	public NinjaService(NinjaRepository repo) {
		this.repo = repo;

	}
		
		public List<Ninja> all() {
			return repo.findAll();
		}
		
		
		public Ninja update(Ninja ninja) {
			return repo.save(ninja);
		}
		
		
		

		public NinjaRepository getRepo() {
			return repo;
		}

		public Ninja create(Ninja ninja) {
		return repo.save(ninja);
	}
		public void delete(Long id) {
			repo.deleteById(id);
		}
		
	
	}



