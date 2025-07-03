package com.jsp.WorkFlowInfo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.WorkFlowInfo.dto.UpdateWfDTO;
import com.jsp.WorkFlowInfo.dto.WFDTO;
import com.jsp.WorkFlowInfo.entity.WFEntity;
import com.jsp.WorkFlowInfo.repository.WFRepository;
import com.jsp.WorkFlowInfo.service.WFService;

@Component
public class WFServiceImpl implements WFService
{
	@Autowired
	private WFRepository wfRepository;
	@Override
	public void processCreateWF(WFDTO dto) 
	{
	    WFEntity wFEntity = wfRepository.findByStatusAndWfCode(dto.getStatus(), dto.getWfCode());

	    if (wFEntity != null) 
	    {
	        // Update the existing entity
	        wFEntity.setWfName(dto.getWfName());
	        wFEntity.setSourceData(dto.getWfSourceData());
	        wFEntity.setModifiedDate(new Date());
	        wfRepository.update(wFEntity);
	    } 
	    else 
	    {
	        // Create a new entity
	        wFEntity = new WFEntity();
	        wFEntity.setWfName(dto.getWfName());
	        wFEntity.setWfCode(dto.getWfCode());
	        wFEntity.setVersion(dto.getVersion());
	        wFEntity.setWfId(dto.getWfCode() +"-"+ dto.getVersion()); 
	        wFEntity.setSourceData(dto.getWfSourceData());
	        wFEntity.setStatus(dto.getStatus());
	        wFEntity.setCreatedDate(new Date());
	        wfRepository.save(wFEntity);
	       
	    }
	    
	}
	@Override
	public void processUpdateStatus(UpdateWfDTO dto) 
	{
		  WFEntity wFEntity = wfRepository.findByStatusAndWfCode(dto.getStatus(), dto.getWfCode());

		    if (wFEntity != null) 
		    {
		        String wfCode = wFEntity.getWfCode();
		        String status = wFEntity.getStatus();
		        String version = wFEntity.getVersion();
		        
		        if(wfCode.equals("SMS")&& status.equals("DRAFT")) 
		        {
		        	 int number = Integer.parseInt(version);
		        	 number++;
		        	 version=String.valueOf(number);
		        	 
		        	 wFEntity.setVersion(version);
		 	         wFEntity.setWfId(dto.getWfCode() +version); 
		 	         
		        }
		       
		        
		        
		        wfRepository.update(wFEntity);
		    } 
		
	}


}
