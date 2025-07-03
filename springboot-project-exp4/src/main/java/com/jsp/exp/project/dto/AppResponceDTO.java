package com.jsp.exp.project.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppResponceDTO
{
	private String status;
	private String statusCode;
	private Object data;
	private String error;

}
