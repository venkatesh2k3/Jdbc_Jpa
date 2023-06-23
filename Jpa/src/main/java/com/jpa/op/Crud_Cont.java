package com.jpa.op;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Crud_Cont {
	 @Autowired
	 Crud_Serv cs;
	  @PostMapping("/insert")
	    public Crud_Pojo insert(@RequestBody Crud_Pojo cp) {
			return cs.insert(cp);
		  
	  }
}
