package com.jsp.WorkFlowInfo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.WorkFlowInfo.config.AppConfig;
import com.jsp.WorkFlowInfo.controller.WFController;
import com.jsp.WorkFlowInfo.dto.UpdateWfDTO;
import com.jsp.WorkFlowInfo.dto.WFDTO;

public class App 
{
    public static void main(String[] args) 
    {
    	saveWf();
    	System.out.println("Data saved successfully");
    }
    
    private static AnnotationConfigApplicationContext getContext() 
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        return context;
    }
    
    public static void saveWf() 
    {
        AnnotationConfigApplicationContext context = getContext();
        WFDTO wfDTO = new WFDTO();
        
        wfDTO.setWfName("TESTSMS-1");
        wfDTO.setWfCode("SMS");
        wfDTO.setVersion("0");
        wfDTO.setWfSourceData("XML");
        wfDTO.setStatus("ACTIVE");

        WFController wfController = context.getBean(WFController.class);
        wfController.createWf(wfDTO);
        context.close();
    }
    
    public static void updateWf() 
    {
        AnnotationConfigApplicationContext context = getContext();
        UpdateWfDTO updateWfDTO=new UpdateWfDTO();
        
        updateWfDTO.setWfId(null);
        updateWfDTO.setStatus(null);
        updateWfDTO.setStatus(null);
        WFController wfController = context.getBean(WFController.class);
        wfController.updateStatus(updateWfDTO);
        context.close();
    }
    
    
}
