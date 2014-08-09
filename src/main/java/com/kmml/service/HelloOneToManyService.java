package com.kmml.service;

import com.kmml.model.HelloOneToMany;

public interface HelloOneToManyService {
	
	HelloOneToMany save (HelloOneToMany helloOneToMany);
	HelloOneToMany find (Long id);
	HelloOneToMany update (HelloOneToMany helloOneToMany);

}
