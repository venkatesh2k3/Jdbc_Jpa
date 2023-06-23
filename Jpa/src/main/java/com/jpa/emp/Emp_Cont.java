package com.jpa.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Emp_Cont {
@Autowired
Emp_Serv es;
@PostMapping("/emp-insert")
public Emp_Pojo insert(@RequestBody Emp_Pojo ep) {
			return es.insert(ep);
}}
