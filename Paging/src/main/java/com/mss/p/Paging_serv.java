package com.mss.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Paging_serv {
	@Autowired
	JdbcTemplate jt;

	public List paging(int pageno, int pagesize) {
		List l = new ArrayList();
		HashMap hm = null;
		List<Map<String, Object>> ls = new ArrayList<Map<String, Object>>();
		String sql = "select * from mySql.paging limit ? offset ?";
		ls = jt.queryForList(sql, pagesize, pagesize * pageno);
		for (Map m : ls) {
			hm = new HashMap();
			hm.put("id", m.get("id"));
			hm.put("name", m.get("name"));
			l.add(hm);
		}
		return l;
	}
}
