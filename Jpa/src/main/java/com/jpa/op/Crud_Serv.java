package com.jpa.op;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Crud_Serv {
	@Autowired
	Crud_Repos cr;
	public Crud_Pojo insert(Crud_Pojo cp) {
		
		return cr.save(cp);
	}

}
