package com.jsp.usm.config;

import java.util.HashMap;
import java.util.Map;

public class MysqlJpaConfig
{
	public void getEntityManagerFactory() 
	{
		Map<String , String> dbPropsMap = new HashMap<String,String>();
		dbPropsMap.put("jakarta.persistence.jdbc.url", "jdbc:mysql://localhost:3306/dev_config");
		dbPropsMap.put("jakarta.persistence.jdbc.username", "root");
		dbPropsMap.put("jakarta.persistence.jdbc.password", "root");
		dbPropsMap.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
	}

}
