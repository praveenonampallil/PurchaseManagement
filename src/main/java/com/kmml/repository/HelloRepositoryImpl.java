package com.kmml.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.kmml.model.Hello;

@Repository("goalRepository")
public class HelloRepositoryImpl implements HelloRepository {
	
	@PersistenceContext
	private EntityManager em;

	public Hello save(Hello hello) {
		
		em.persist(hello);
		em.flush();
		
		return hello;
	}
	
	public Hello find(Long id) {
		
		Hello hello=em.find(Hello.class,id);
		em.flush();
		
		return hello;
	}
	public List<Hello> findAll() {
		
	List<Hello> hellos =  em.createQuery("SELECT p FROM Hello p").getResultList();	
		return hellos;
	}
	
	public Hello update(Hello hello) {
		
		em.merge(hello);
		em.flush();
		
		return hello;
		
	
	}
}
