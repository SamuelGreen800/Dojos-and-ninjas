package com.samgreen.dojosandninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")

public class Dojo {
	    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Size(min=1, max=200, message="Please enter a location")
	private String name;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date created_at;
	@DateTimeFormat(pattern = "yyy-MM-dd")
    private Date updated_at;
	
	@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
	private List<Ninja> ninjas;
	
	
	@PrePersist
	protected void onCreate(){
		this.created_at = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updated_at = new Date();
	}
	    
	public Dojo() {
	}
	
	public Dojo(String name, Date created_at, Date updated_at, List<Ninja> ninjas) {
		this.name = name;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.ninjas = ninjas;
	}
	
	    
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}


	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
	}



