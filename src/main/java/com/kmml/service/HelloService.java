package com.kmml.service;

import java.util.List;

import com.kmml.model.Hello;

public interface HelloService {
	Hello save (Hello hello);
	Hello find (Long id);
	List<Hello> findAll ();
	Hello update (Hello hello);

}
