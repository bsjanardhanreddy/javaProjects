package com.jsp.DataManagement.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jsp.DataManagement.dto.AppResponseDTO;
import com.jsp.DataManagement.dto.DataSourceDTO;
import com.jsp.DataManagement.service.impl.DataSourceServiceImpl;
@Controller
public class DataSourceController 
{
	@Autowired
	private DataSourceServiceImpl dataSourceServiceImpl;
	
	public AppResponseDTO createDataSource(DataSourceDTO dataSourceDTO ) 
	{
		return dataSourceServiceImpl.processCreate(dataSourceDTO);
	}
	
	public AppResponseDTO getDataSourceById(BigInteger alt_key) 
	{
		return dataSourceServiceImpl.getDataSourceEntityByAltKey(alt_key);
	}
	public AppResponseDTO getAllDataSource() 
	{
		return dataSourceServiceImpl.getAllDataSourceEntity();
	}
	
	public AppResponseDTO getAllDataSourceByDbNameAndHostName(String dbName,String hostName) 
	{
		return dataSourceServiceImpl.getAllDataSourceEntityByDbNameAndHostName(dbName,hostName);
	}
	
	public AppResponseDTO updateDataSource(BigInteger alt_key,DataSourceDTO dataSourceDTO ) 
	{
		return dataSourceServiceImpl.updateDataSourceEntityByAltKey(alt_key,dataSourceDTO);
	}
	
	public AppResponseDTO deleteDataSourceById(BigInteger alt_key) 
	{
		return dataSourceServiceImpl.deleteDataSourceEntityByAltKey(alt_key);
	}
}
