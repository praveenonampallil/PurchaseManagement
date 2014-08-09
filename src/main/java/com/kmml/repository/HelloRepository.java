package com.kmml.repository;

import java.util.List;

import com.kmml.model.Hello;

public interface HelloRepository {
	
	Hello save (Hello hello);
	Hello find (Long id);
	List<Hello> findAll ();
	Hello update(Hello hello);

}
