package com.jsp.workqueue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppResponceDTO
{
	private String status;
	private String statusCode;
	private Object data;
	private String error;

}
