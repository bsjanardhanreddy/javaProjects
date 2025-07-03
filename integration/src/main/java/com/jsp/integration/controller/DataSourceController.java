package com.jsp.integration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.integration.dto.DataSourceDTO;
import com.jsp.integration.entity.DataSourceEntity;
import com.jsp.integration.service.MysqlService;

@Controller
public class DataSourceController 
{
	@Autowired
	MysqlService mysqlService;
	
	@RequestMapping(value="/create")
	public ModelAndView create(DataSourceDTO dataSourceDTO) 
	{
			mysqlService.processCreate(dataSourceDTO);
		    return new  ModelAndView("home.jsp");
	}
	
	@RequestMapping(value="/get-data-sources")
	public ModelAndView getDataSources() 
	{
		    List<DataSourceEntity> dataSourceEntitys = mysqlService.ProcessGetAllDataSources();
		    ModelAndView modelAndView = new ModelAndView("dataSource.jsp");
		    modelAndView.addObject("dsList",dataSourceEntitys);
		    return modelAndView;  
	}
	
	
}
