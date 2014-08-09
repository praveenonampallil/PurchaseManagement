package com.kmml.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class HelloOneToMany {
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String name;
	
	@ManyToOne()
	private Hello hello;

	public Hello getHello() {
		return hello;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setHello(Hello hello) {
		this.hello = hello;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
