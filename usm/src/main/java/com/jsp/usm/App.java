package com.jsp.usm;

import java.util.List;

import com.jsp.usm.controller.UserController;
import com.jsp.usm.dto.UserDTO;

public class App 
{
	private static final UserController USER_CONTROLLER=new UserController();
	
    public static void saveUser() 
    {
    	UserDTO userDTO =new UserDTO();
    	userDTO.setFirstName("Mohan");
    	userDTO.setLastName("Lal");
    	userDTO.setEmail("mohanlal@gmail.com");
    	userDTO.setCountry("India");
    	userDTO.setPincode("560001");
    	userDTO.setMobileNumber("2345678998");
    	
    	USER_CONTROLLER.createUser(userDTO);
    }
    
    public static void fetchAllUsers() 
    {

    	List<UserDTO> allUsers = USER_CONTROLLER.getAllUser();
    	for (UserDTO userDTO : allUsers) 
    	{
    		System.out.println("User[firstName=" + userDTO.getLastName() + ", lastName=" + userDTO.getLastName() + ", email=" + userDTO.getEmail() + ", country="
			+ userDTO.getCountry() + ", mobileNumber=" + userDTO.getMobileNumber() + ", pincode=" + userDTO.getPincode() + "]");
    		//System.out.println(userDTO.toString());
		}
    }
    
    public static void fetchUserById(long id) 
    {
    	UserDTO user = USER_CONTROLLER.getUserById(id);
    	System.out.println("User[firstName=" + user.getLastName() + ", lastName=" + user.getLastName() + ", email=" + user.getEmail() + ", country="
    			+ user.getCountry() + ", mobileNumber=" + user.getMobileNumber() + ", pincode=" + user.getPincode() + "]");
    	//System.out.println(user.toString());
    }
    
    public static void updateUser(long id)
    {
    	UserDTO userDTO =new UserDTO();
    	userDTO.setFirstName("Mohan");
    	userDTO.setLastName("Lal");
    	userDTO.setEmail("mohanlal@gmail.com");
    	userDTO.setMobileNumber("2345678998");
    	
    	long result=USER_CONTROLLER.updateUser(id,userDTO);
    	if(result!=0) 
    	{
    		System.out.println(id+": User Updated Successfully");
    	}
    	
	}
    
    public static void deleteUser(long id)
    {
    	long result=USER_CONTROLLER.deleteUserById(id);
    	if(result!=0) 
    	{
    		System.out.println(id+": User deleted Successfully");
    	}
	}
    
    public static void main(String[] args)
    {
    	//saveUser(); 
    	//updateUser(124);
    	//fetchUserById(123);
    	//deleteUser(123);
    	
	}
}
