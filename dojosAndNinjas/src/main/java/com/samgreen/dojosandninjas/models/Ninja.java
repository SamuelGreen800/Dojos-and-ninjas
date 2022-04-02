package com.samgreen.dojosandninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="ninjas")

	public class Ninja {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @NotBlank(message="Please enter a first name")
		
	    private String first_name;
	    @NotBlank(message="Please enter a last name")
		
	    private String last_name;
	    @NotNull(message="Age must not be blank!")
	    private int age;
		
	    @Column(updatable=false)
	    @DateTimeFormat(pattern = "yyy-MM-dd")
	    private Date created_at;
	    @DateTimeFormat(pattern = "yyy-MM-dd")
	    private Date updated_at;
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="dojo_id")
	    private Dojo dojo;
	    
	    public Ninja() {
	        
	    }
	    
	    public Ninja(Long id, String first_name, String last_name, int age, Date created_at, Date updated_at, Dojo dojo) {
	    	this.id = id;
	    	this.first_name = first_name;
	    	this.last_name = last_name;
	    	this.age = age;
	    	this.created_at = created_at;
	    	this.updated_at = updated_at;
	    	this.dojo = dojo;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

	
		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
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

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Dojo getDojo() {
			return dojo;
		}

		public void setDojo(Dojo dojo) {
			this.dojo = dojo;
		}
	
	    
	    
	}




