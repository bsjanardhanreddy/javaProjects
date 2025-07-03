package com.jsp.usm.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * note @Configuration internally using @Component
 *  
 *  Indicates that a class declares one or more @Bean methods
 *  and may be processed by the Spring container to generate bean definitions 
 *  and service requests for those beans at runtime. 
 *
 */
 
@Configuration
public class MysqlConfig 
{

	private static final  String DB_URL="jdbc:mysql://localhost:3306/dev_config";
	private static final  String DB_USER_NAME="root";
	private static final  String DB_PASSWORD="root";
	
	@Bean
	public  Connection getConnection() 
	{
		Connection connection=null;
		try 
		{
			connection = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return connection;
	}
}
