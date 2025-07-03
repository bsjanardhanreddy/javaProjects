package com.jsp.usm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.usm.config.AppConfig;
import com.jsp.usm.controller.UserController;

public class AppTest 
{
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context=
		new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		UserController bean = context.getBean(UserController.class);
		UserController bean1 = context.getBean(UserController.class);
		
//		List<UserDTO> allUser = bean.getAllUser();
//		allUser.forEach(each-> System.out.println(each));
	}

}
