package com.jsp.FirstProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController 
{
		@GetMapping("/hello")
		public String helloWorld() 
		{
			return "Hello World How Are you re Jhonty";
		}

}
 