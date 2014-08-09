package com.kmml.repository;

import com.kmml.model.HelloOneToMany;

public interface HelloOneToManyRepository {
	
	HelloOneToMany save (HelloOneToMany helloOneToMany);
	HelloOneToMany find (Long id);
	HelloOneToMany update(HelloOneToMany helloOneToMany);

}
