package com.jsp.usm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jsp.usm.dto.UserDTO;
import com.jsp.usm.service.impl.UserServiceImpl;

@Scope("prototype")
@Component
public class UserController 
{
	@Autowired
	private UserServiceImpl UserServiceImpl;

	public UserController()
	{
		System.out.println(this.getClass().getSimpleName());
	}
	
	public void createUser(UserDTO userDto)
	{
		//using Statement interface 
		//USER_SERVICE_IMPL.processCreateUser(userDto);
		
		//using PrepareStatement interface
		UserServiceImpl.processSaveUser(userDto);
	}
	
	public List<UserDTO> getAllUser()
	{
		return UserServiceImpl.getAllUsers();
	}
	
	public UserDTO getUserById(long id)
	{
		return UserServiceImpl.getUserById(id);
	}
	
	public long updateUser(long id,UserDTO userDto)
	{
		return UserServiceImpl.updateUser(id,userDto);
		
	}
	public long deleteUserById(long id)
	{
		return UserServiceImpl.deleteUser(id);
	}
	
}
