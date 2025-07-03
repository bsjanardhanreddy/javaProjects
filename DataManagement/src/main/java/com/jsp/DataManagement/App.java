package com.jsp.DataManagement;

import java.math.BigInteger;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.DataManagement.config.AppConfig;
import com.jsp.DataManagement.controller.DataSourceController;
import com.jsp.DataManagement.dto.AppResponseDTO;
import com.jsp.DataManagement.dto.DataSourceDTO;
import com.jsp.DataManagement.entity.DataSourceEntity;

public class App 
{
	
    public static void main(String[] args) 
    {
        //readDataSourceById("124");
        //deleteDataSource("123");
    	//saveDataSource() ;
    	//updateDataSource("124") ;
    	//readAllDataSource() ;
    	readAllDataSourceByDbNameAndHostName("demo","192.168.1.50");
    }

    private static AnnotationConfigApplicationContext getContext() 
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        return context;
    }
    
    public static void saveDataSource() 
    {
        AnnotationConfigApplicationContext context = getContext();
        DataSourceDTO dataSourceDTO = new DataSourceDTO();
        
        dataSourceDTO.setDbName("demo");
        dataSourceDTO.setDbPassword("test");
        dataSourceDTO.setHostName("192.168.1.50");
        dataSourceDTO.setPortNumber("3360");

        DataSourceController dataSourceController = context.getBean(DataSourceController.class);
        AppResponseDTO createDataSource = dataSourceController.createDataSource(dataSourceDTO);
        System.out.println(createDataSource);
        context.close(); // optional: close context to release resources
    }

    public static void readDataSourceById(String alt_key) 
    {
        AnnotationConfigApplicationContext context = getContext();
        DataSourceController dataSourceController = context.getBean(DataSourceController.class);
        AppResponseDTO dataSourceById = dataSourceController.getDataSourceById(new BigInteger(alt_key));
        System.out.println(dataSourceById);
        context.close();
    }
    
    public static void readAllDataSource() 
    {
        AnnotationConfigApplicationContext context = getContext();
        DataSourceController dataSourceController = context.getBean(DataSourceController.class);
        AppResponseDTO dataSourceById = dataSourceController.getAllDataSource();
        List<DataSourceEntity> data =  (List<DataSourceEntity>)dataSourceById.getData();
        System.out.println("AppResponseDTO [status=" + dataSourceById.getStatus() + ", errorMessage="+dataSourceById.getErrorMessage()+" ]");
        for (DataSourceEntity dataSourceEntity : data)
        {
			System.out.println(dataSourceEntity);
		}
        context.close();
    }
    
    public static void readAllDataSourceByDbNameAndHostName(String dbName,String hostName) 
    {
        AnnotationConfigApplicationContext context = getContext();
        DataSourceController dataSourceController = context.getBean(DataSourceController.class);
        AppResponseDTO ByDbNameAndHostName = dataSourceController.getAllDataSourceByDbNameAndHostName(dbName,hostName);
       
        List<DataSourceEntity> data =  (List<DataSourceEntity>)ByDbNameAndHostName.getData();
       
        System.out.println("AppResponseDTO [status=" + ByDbNameAndHostName.getStatus() + ", errorMessage="+ByDbNameAndHostName.getErrorMessage()+" ]");
        
        for (DataSourceEntity dataSourceEntity : data)
        {
			System.out.println(dataSourceEntity);
		}
        context.close();
    }

    public static void updateDataSource(String alt_key) 
    {
        AnnotationConfigApplicationContext context = getContext();
        DataSourceDTO dataSourceDTO = new DataSourceDTO();
        
        dataSourceDTO.setDbName("mysql");
        dataSourceDTO.setDbPassword("root");
        dataSourceDTO.setHostName("192.168.1.50");
        dataSourceDTO.setPortNumber("3360");

        DataSourceController dataSourceController = context.getBean(DataSourceController.class);
        AppResponseDTO createDataSource = dataSourceController.updateDataSource(new BigInteger(alt_key),dataSourceDTO);
        System.out.println(createDataSource);
        context.close(); // optional: close context to release resources
    }
    public static void deleteDataSource(String alt_key) 
    {
        AnnotationConfigApplicationContext context = getContext();
        DataSourceController dataSourceController = context.getBean(DataSourceController.class);
        AppResponseDTO dataSourceById = dataSourceController.deleteDataSourceById(new BigInteger(alt_key));
        System.out.println(dataSourceById);
        context.close();
    }

    
}
