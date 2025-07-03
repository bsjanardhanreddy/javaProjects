package com.jsp.integration.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsp.integration.entity.DataSourceEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class MysqlRepository 
{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void save(DataSourceEntity dataSourceEntity) 
	{
		entityManager.persist(dataSourceEntity);
	}
	
	public List<DataSourceEntity> findAll() 
	{
		String hql=" FROM DataSourceEntity";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}
	
}
