package com.jsp.WorkFlowInfo.repository;
import org.springframework.stereotype.Component;

import com.jsp.WorkFlowInfo.entity.WFEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Component
public class WFRepository 
{
	@PersistenceContext
	EntityManager entityManager;
	@Transactional
	public void save(WFEntity entity) 
	{
		entityManager.persist(entity);
	}
	
	@Transactional
	public void update(WFEntity entity) 
	{
		entityManager.merge	(entity);
	}
	
	
	 public WFEntity findByStatusAndWfCode(String status, String wfCode) {
	        String hql = "FROM WFEntity WHERE status = :wfStatus AND wfCode = :code";
	        Query query = entityManager.createQuery(hql);
	        query.setParameter("wfStatus", status);
	        query.setParameter("code", wfCode);
	        try 
	        {
	            return (WFEntity) query.getSingleResult();
	        } 
	        catch (Exception e)
	        {
	            return null; // Handle better in real applications
	        }
	    }
}
