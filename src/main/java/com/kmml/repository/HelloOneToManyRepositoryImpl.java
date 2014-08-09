package com.kmml.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.kmml.model.HelloOneToMany;

@Repository("helloOneToManyRepository")
public class HelloOneToManyRepositoryImpl implements HelloOneToManyRepository {

	@PersistenceContext
	private EntityManager em;

	public HelloOneToMany save(HelloOneToMany helloOneToMany) {
		em.persist(helloOneToMany);
		em.flush();
		
		return helloOneToMany;
	}

	public HelloOneToMany find(Long id) {
		HelloOneToMany helloOneToMany=em.find(HelloOneToMany.class,id);
		em.flush();
		
		return helloOneToMany;
	}

	public HelloOneToMany update(HelloOneToMany helloOneToMany) {
		em.merge(helloOneToMany);
		em.flush();
		
		return helloOneToMany;
	}

}
