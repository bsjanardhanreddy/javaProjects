package com.jsp.DataManagement.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.jsp.DataManagement.dto.AppResponseDTO;
import com.jsp.DataManagement.dto.DataSourceDTO;
import com.jsp.DataManagement.entity.DataSourceEntity;
import com.jsp.DataManagement.repository.DataSourceRepository;
import com.jsp.DataManagement.service.DataSourceService;

@Service
//@Component
public class DataSourceServiceImpl implements DataSourceService
{
	@Autowired
	private DataSourceRepository dataSourceRepository;

	@Override
	public AppResponseDTO processCreate(DataSourceDTO dataSourceDTO) 
	{	 	AppResponseDTO responce=null;
			try 
			{
				DataSourceEntity dataSourceEntity=new DataSourceEntity();
				
				dataSourceEntity.setAltKey(new BigInteger("126"));
				dataSourceEntity.setDbName(dataSourceDTO.getDbName());
				dataSourceEntity.setDbPassword(dataSourceDTO.getDbPassword());
				dataSourceEntity.setHostName(dataSourceDTO.getHostName());
				dataSourceEntity.setPortNumber(dataSourceDTO.getPortNumber());
				dataSourceEntity.setCreatedDate(new Date());
				dataSourceRepository.save(dataSourceEntity);
				responce=new AppResponseDTO("INSERTED SUCCESSFULLY", null, dataSourceEntity);
			} 
			catch (Exception e)
			{
				responce=new AppResponseDTO("FAILED TO INSERT", e.getLocalizedMessage(),null);
			}
		return responce;
	}
	@Override
	public AppResponseDTO getDataSourceEntityByAltKey(BigInteger alt_key) 
	{
		AppResponseDTO responce=null;
		try 
		{
			DataSourceEntity sourceEntity = dataSourceRepository.findById(alt_key);
			responce=new AppResponseDTO("FETCHED SUCCESSFULLY", null, sourceEntity);
		} catch (Exception e) 
		{
			responce=new AppResponseDTO("FAILED TO FETCH", e.getLocalizedMessage(),null);
		}
		return responce;
		
	}
	
	@Override
	public AppResponseDTO getAllDataSourceEntity() 
	{
		
		AppResponseDTO responce=null;
		try 
		{
			List<DataSourceEntity> dataSourceList = dataSourceRepository.findAll();
			responce=new AppResponseDTO("FETCHED SUCCESSFULLY", null, dataSourceList);
		} catch (Exception e) 
		{
			e.printStackTrace();
			responce=new AppResponseDTO("FAILED TO FETCH", e.getLocalizedMessage(),null);
		}
		return responce;
	}
	
	@Override
	public AppResponseDTO getAllDataSourceEntityByDbNameAndHostName(String dbName,String hostName) 
	{
		AppResponseDTO responce=null;
		try 
		{
			List<DataSourceEntity> dataSourceList = dataSourceRepository.findAllByDbNameAndHostName(dbName,hostName);
			responce=new AppResponseDTO("FETCHED SUCCESSFULLY", null, dataSourceList);
		} catch (Exception e) 
		{
			e.printStackTrace();
			responce=new AppResponseDTO("FAILED TO FETCH", e.getLocalizedMessage(),null);
		}
		return responce;
	}
	
	
	
	@Override
	public AppResponseDTO updateDataSourceEntityByAltKey(BigInteger alt_key,DataSourceDTO dataSourceDTO) 
	{	AppResponseDTO responce=null;
		try 
		{
			DataSourceEntity dataSourceEntity=new DataSourceEntity();
			dataSourceEntity.setDbName(dataSourceDTO.getDbName());
			dataSourceEntity.setDbPassword(dataSourceDTO.getDbPassword());
			dataSourceEntity.setHostName(dataSourceDTO.getHostName());
			dataSourceEntity.setPortNumber(dataSourceDTO.getPortNumber());
			dataSourceEntity.setModifiedDate(new Date());
			DataSourceEntity updateById = dataSourceRepository.updateById( alt_key,dataSourceEntity);
			responce=new AppResponseDTO("UPDATED SUCCESSFULLY", null, updateById);
		} 
		catch (Exception e) 
		{
			responce=new AppResponseDTO("FAILED TO UPDATE", null, null);
		}
		
		return responce;
	}

	
	@Override
	public AppResponseDTO deleteDataSourceEntityByAltKey(BigInteger alt_key) 
	{
		AppResponseDTO responce=null;
		try 
		{
			dataSourceRepository.deleteById(alt_key);
			responce=new AppResponseDTO("DELETED SUCCESSFULLY", null,null );
		} catch (Exception e) 
		{
			e.printStackTrace();
			responce=new AppResponseDTO("FAILED TO DELETE",e.getLocalizedMessage(),null);
		}
		return responce;
		
	}
		

}
