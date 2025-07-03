package com.jsp.DataManagement.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;
@Configuration
@EnableTransactionManagement
public class MysqlConfig 
{
	@Bean
	public DataSource getDataSource() 
	{
		DriverManagerDataSource dataSource =new DriverManagerDataSource ();
		dataSource.setUrl("jdbc:mysql://localhost:3306/dev_config");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DataSource dataSource) 
	{
		LocalContainerEntityManagerFactoryBean entityManagerFactory
		=new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setPackagesToScan("com.jsp.DataManagement.entity");
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return entityManagerFactory;
	}
	@Bean
	public JpaTransactionManager getTransactionManager(EntityManagerFactory managerFactory) 
	{
		return new JpaTransactionManager(managerFactory);
	}
}
