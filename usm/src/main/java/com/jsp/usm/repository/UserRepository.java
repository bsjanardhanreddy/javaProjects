package com.jsp.usm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.usm.dto.UserDTO;

@Component
public class UserRepository 
{
	@Autowired
	Connection connection;
	
	public UserRepository()
	{
		System.out.println( this.getClass().getSimpleName());
	}
	public void save(String userQuery) 
	{
		try 
		{
			Statement statement = connection.createStatement();
			boolean execute = statement.execute(userQuery);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public void save(String userQuery,UserDTO userDTO) 
	{
		try 
		{
			PreparedStatement prepareStatement 
			=connection.prepareStatement(userQuery);
			prepareStatement.setInt(1, 125);
			prepareStatement.setString(2, userDTO.getFirstName());
			prepareStatement.setString(3, userDTO.getLastName());
			prepareStatement.setString(4, userDTO.getEmail());
			prepareStatement.setString(5, userDTO.getCountry());
			prepareStatement.setString(6, userDTO.getPincode());
			prepareStatement.setString(7, userDTO.getMobileNumber());
			
			int executeUpdate = prepareStatement.executeUpdate();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public ResultSet findAll() 
	{
		String sqlQuery="SELECT * FROM `user_info`";
		ResultSet rs=null;
		try 
		{
			PreparedStatement prepareStatement 
			=connection.prepareStatement(sqlQuery);
			rs=prepareStatement.executeQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet findById(long id) 
	{
		String sqlQuery="SELECT * FROM `user_info` where alt_key=?";
		ResultSet rs=null;
		try 
		{
			PreparedStatement ps
			= connection.prepareStatement(sqlQuery);
			ps.setLong(1, id);
			
			rs=ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public int update(String userQuery,UserDTO userDTO,long id) 
	{
		int result=0;
		try 
		{
			PreparedStatement prepareStatement 
			=connection.prepareStatement(userQuery);
			prepareStatement.setString(1, userDTO.getFirstName());
			prepareStatement.setString(2, userDTO.getLastName());
			prepareStatement.setString(3, userDTO.getEmail());
			prepareStatement.setString(4, userDTO.getMobileNumber());
			prepareStatement.setLong(5, id);
			
			result = prepareStatement.executeUpdate();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	
	public long delete(String deleterQuery,long id) 
	{
		
		int rs = 0;
		try 
		{
			PreparedStatement ps
			= connection.prepareStatement(deleterQuery);
			ps.setLong(1, id);
			
			rs=ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	
}
