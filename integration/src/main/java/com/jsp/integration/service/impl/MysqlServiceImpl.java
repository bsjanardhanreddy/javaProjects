package com.jsp.integration.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.integration.dto.DataSourceDTO;
import com.jsp.integration.entity.DataSourceEntity;
import com.jsp.integration.repository.MysqlRepository;
import com.jsp.integration.service.MysqlService;



@Service
public class MysqlServiceImpl implements MysqlService
{
	@Autowired
	private MysqlRepository dataSourceRepository;
	
	public void processCreate(DataSourceDTO dataSourceDTO) 
	{	 	DataSourceEntity dataSourceEntity=new DataSourceEntity();
				
				dataSourceEntity.setUserName(dataSourceDTO.getUserName());
				dataSourceEntity.setPassword(dataSourceDTO.getPassword());
				dataSourceEntity.setDbName(dataSourceDTO.getDbName());
				dataSourceEntity.setHostName(dataSourceDTO.getHostName());
				dataSourceEntity.setPortNumber(dataSourceDTO.getPortNumber());
				dataSourceEntity.setCreatedDate(new Date());
				dataSourceRepository.save(dataSourceEntity);
	}

	@Override
	public List<DataSourceEntity> ProcessGetAllDataSources() 
	{
		return dataSourceRepository.findAll();
	}

}
