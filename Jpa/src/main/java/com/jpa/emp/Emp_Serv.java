package com.jpa.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Emp_Serv {
@Autowired
Emp_Repo er;
	public Emp_Pojo insert(Emp_Pojo ep) {
		return er.save(ep);
	}

}
