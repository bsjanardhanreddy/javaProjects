package com.jsp.usm.service;

import java.util.List;

import com.jsp.usm.dto.UserDTO;

public interface UserService 
{

	//using Statement interface 
	public abstract void processCreateUser(UserDTO userDto);
	//using PrepareStatement interface
	public abstract void processSaveUser(UserDTO userDto);
	public List<UserDTO> getAllUsers();
	public UserDTO getUserById(long id);
	public long deleteUser(long id);
	public long updateUser(long id,UserDTO userDto) ;
	
}
