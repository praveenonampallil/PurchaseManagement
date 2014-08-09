package com.kmml.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Hello {
	
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String name;
	
	@OneToMany(mappedBy="hello",cascade=CascadeType.ALL)
	private List<HelloOneToMany> helloOneToMany= new ArrayList<HelloOneToMany>();

	public List<HelloOneToMany> getHelloOneToMany() {
		return helloOneToMany;
	}

	public Long getId() {
		return id;
	}
	
	

	public String getName() {
		return name;
	}

	public void setHelloOneToMany(List<HelloOneToMany> helloOneToMany) {
		this.helloOneToMany = helloOneToMany;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
