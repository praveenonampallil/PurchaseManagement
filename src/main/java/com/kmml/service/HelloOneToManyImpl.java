package com.kmml.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmml.model.HelloOneToMany;
import com.kmml.repository.HelloOneToManyRepository;


@Service("helloOneToManyService")
public class HelloOneToManyImpl implements HelloOneToManyService {
	
	@Autowired
	private HelloOneToManyRepository helloOneToManyRepository;

	@Transactional
	public HelloOneToMany save(HelloOneToMany helloOneToMany) {
		
		return helloOneToManyRepository.save(helloOneToMany);
	}		

	@Transactional
	public HelloOneToMany find(Long id) {
		
		return helloOneToManyRepository.find(id);
	}

	@Transactional
	public HelloOneToMany update(HelloOneToMany helloOneToMany) {
		
		return helloOneToManyRepository.update(helloOneToMany);
	}

}
