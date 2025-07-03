package com.jsp.WorkFlowInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.WorkFlowInfo.dto.UpdateWfDTO;
import com.jsp.WorkFlowInfo.dto.WFDTO;
import com.jsp.WorkFlowInfo.service.impl.WFServiceImpl;

@Component
public class WFController 
{
	@Autowired
	private WFServiceImpl wfServiceImpl;
	
	public void createWf(WFDTO dto) 
	{
		wfServiceImpl.processCreateWF(dto);
	}
	public void updateStatus(UpdateWfDTO dto) 
	{
		
		
	}
}
