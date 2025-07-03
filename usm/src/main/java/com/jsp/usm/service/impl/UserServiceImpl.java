package com.jsp.usm.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.usm.dto.UserDTO;
import com.jsp.usm.repository.UserRepository;
import com.jsp.usm.service.UserService;

@Component
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository User_Repository;
	
	public UserServiceImpl() 
	{
		System.out.println(this.getClass().getSimpleName());
	}
	private String prepareUserInsertQuery(UserDTO userDTO) 
	{
		StringBuilder query=new StringBuilder();
		query.append("insert into user_info");
		query.append("(`alt_key`,`first_name`,`last_name`,`email`,`country`,`pin_code`,`mobile_number`)");
		query.append("values(");
		query.append(123);
		query.append(",' ");
		query.append(userDTO.getFirstName());
		query.append(" ' ,' ");
		query.append(userDTO.getLastName());
		query.append(" ' ,' ");
		query.append(userDTO.getEmail());
		query.append(" ' ,' ");
		query.append(userDTO.getCountry());
		query.append(" ' ,' ");
		query.append(userDTO.getPincode());
		query.append(" ' ,' ");
		query.append(userDTO.getMobileNumber());
		query.append(" ' ) ");
		return query.toString();
	}
	@Override
	public void processCreateUser(UserDTO userDTO) 
	{
//		final UserRepository USER_REPOSITORY=new UserRepository();
		String query = prepareUserInsertQuery(userDTO);
		User_Repository.save(query);
	}
	@Override
	public void processSaveUser(UserDTO userDto)
	{
		
		String query="INSERT INTO `user_info`"
				   + "(`alt_key`, `first_name`, `last_name`,"
				   + " `email`, `country`, `pin_code`,`mobile_number`)"
				   + "VALUES (?,?,?,?,?,?,?)";
		User_Repository.save(query, userDto);
	}
	
	@Override
	public List<UserDTO> getAllUsers()
	{
		ResultSet setOfUsers = User_Repository.findAll();
		List<UserDTO> listOfUsers=new ArrayList<UserDTO>();
		
		if(setOfUsers!=null) 
		{
			try 
			{
				while(setOfUsers.next()) 
				{
					UserDTO userDTO =new UserDTO();
			    	userDTO.setFirstName(setOfUsers.getString("first_name"));
			    	userDTO.setLastName(setOfUsers.getString("last_name"));
			    	userDTO.setEmail(setOfUsers.getString("email"));
			    	userDTO.setCountry(setOfUsers.getString("country"));
			    	userDTO.setPincode(setOfUsers.getString("pin_code"));
			    	userDTO.setMobileNumber(setOfUsers.getString("mobile_number"));
			    	listOfUsers.add(userDTO);
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return listOfUsers;
		
	}
	@Override
	public UserDTO getUserById(long id) 
	{
		ResultSet user = User_Repository.findById(id);
		UserDTO userDTO =new UserDTO();
		if(user!=null) 
		{
			try 
			{
				while(user.next()) 
				{
			    	userDTO.setFirstName(user.getString("first_name"));
			    	userDTO.setLastName(user.getString("last_name"));
			    	userDTO.setEmail(user.getString("email"));
			    	userDTO.setCountry(user.getString("country"));
			    	userDTO.setPincode(user.getString("pin_code"));
			    	userDTO.setMobileNumber(user.getString("mobile_number"));
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return userDTO;
	}
	
	public long updateUser(long id,UserDTO userDto) 
	{
		String sqlQuery=" UPDATE `user_info`"
				      + " SET `first_name`=?, `last_name`=?, `email`=?,`mobile_number`=? WHERE  `alt_key`=?";
		return User_Repository.update(sqlQuery,userDto, id);
	}
	@Override
	public long deleteUser(long id) 
	{
		String sqlQuery="DELETE FROM `user_info`where alt_key=?  ";
		
		return User_Repository.delete(sqlQuery, id);
	}

}
