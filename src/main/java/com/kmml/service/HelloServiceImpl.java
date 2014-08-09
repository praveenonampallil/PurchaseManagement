package com.kmml.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmml.model.Hello;
import com.kmml.repository.HelloRepository;

@Service("helloService")
public class HelloServiceImpl implements HelloService {
	
	@Autowired
	private HelloRepository helloRepository;
	
	@Transactional
	public Hello save(Hello hello) {
		
		return helloRepository.save(hello);
	}
	@Transactional
	public Hello find (Long id)
	{
		return helloRepository.find(id);
	}
	
	@Transactional
	public List<Hello> findAll ()
	{
		return helloRepository.findAll();
	}
	
	@Transactional
	public Hello update (Hello hello)
	{
		return helloRepository.update(hello);
	}

}
