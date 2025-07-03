package com.jsp.DataManagement.repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsp.DataManagement.entity.DataSourceEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
//@Component
public class DataSourceRepository 
{
	/*Expresses a dependency on a container-managed EntityManager 
	  and its associated persistence context.
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void save(DataSourceEntity dataSourceEntity) 
	{
		//entityManager.getTransaction().begin();
		entityManager.persist(dataSourceEntity);
		//entityManager.getTransaction().commit();
	}
	
	public DataSourceEntity findById(BigInteger alt_key) 
	{ 
		
		return entityManager.find(DataSourceEntity.class,alt_key );
	}
	
	public List<DataSourceEntity> findAllByDbNameAndHostName(String dbName,String hostName) 
	{ 
		
		String query="from DataSourceEntity where dbName=:name and hostName=:host";
		Query createQuery = entityManager.createQuery(query);
		createQuery.setParameter("name",dbName);
		createQuery.setParameter("host",hostName);
		return createQuery.getResultList();
	}
	
	public List<DataSourceEntity> findAll() 
	{ 
		String query="from DataSourceEntity";
		Query createQuery = entityManager.createQuery(query);
		return createQuery.getResultList();
	}
	
	
	
	@Transactional
	public DataSourceEntity updateById(BigInteger alt_key,DataSourceEntity dataSourceEntity) 
	{ 
		DataSourceEntity findById = findById(alt_key) ;
		findById.setDbName(dataSourceEntity.getDbName());
		findById.setDbPassword(dataSourceEntity.getDbPassword());
		findById.setHostName(dataSourceEntity.getHostName());
		findById.setPortNumber(dataSourceEntity.getPortNumber());
		findById.setModifiedDate(dataSourceEntity.getModifiedDate());
       return entityManager.merge(findById);
	}
	
	@Transactional
	public void deleteById(BigInteger alt_key) 
	{ 
		DataSourceEntity findById = findById(alt_key) ;
        entityManager.remove(findById);
	}
	
}
