package com.mss.p;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Paging_cont {
	@Autowired
	Paging_serv ps;
	Logger lg =LoggerFactory.getLogger(Paging_serv.class);
	//@GetMapping("/Getting")
//	public String get()
//	{	lg.error("venkatesh");
//		lg.warn("venky");
//		return "hello";
//		
//	}
	@GetMapping("/student-paging/{pageno}/{pagesize}")
	public List paging (@PathVariable int pageno, @PathVariable int pagesize) {
		lg.error("venkatesh");
		lg.warn("venky");
		return ps.paging(pageno,pagesize);
	}
}
