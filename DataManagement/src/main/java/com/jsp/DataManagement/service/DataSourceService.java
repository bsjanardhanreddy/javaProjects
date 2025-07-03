package com.jsp.DataManagement.service;

import java.math.BigInteger;

import com.jsp.DataManagement.dto.AppResponseDTO;
import com.jsp.DataManagement.dto.DataSourceDTO;

public interface DataSourceService 
{
	public AppResponseDTO processCreate(DataSourceDTO dataSourceDTO); 
	public AppResponseDTO getDataSourceEntityByAltKey(BigInteger alt_key);
	public AppResponseDTO getAllDataSourceEntity();
	public AppResponseDTO getAllDataSourceEntityByDbNameAndHostName(String dbName,String hostName);
	public AppResponseDTO updateDataSourceEntityByAltKey(BigInteger alt_key, DataSourceDTO dataSourceDTO);
	public AppResponseDTO deleteDataSourceEntityByAltKey(BigInteger alt_key) ;

}
