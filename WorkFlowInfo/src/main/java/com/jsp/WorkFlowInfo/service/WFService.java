package com.jsp.WorkFlowInfo.service;

import com.jsp.WorkFlowInfo.dto.UpdateWfDTO;
import com.jsp.WorkFlowInfo.dto.WFDTO;

public interface WFService 
{
	public void processCreateWF(WFDTO dto) ;
	public void processUpdateStatus(UpdateWfDTO dto) ;
	
}
