package com.jsp.integration.service;

import java.util.List;

import com.jsp.integration.dto.DataSourceDTO;
import com.jsp.integration.entity.DataSourceEntity;

public interface MysqlService 
{
	public void processCreate(DataSourceDTO dataSourceDTO);
	public List<DataSourceEntity> ProcessGetAllDataSources();

}