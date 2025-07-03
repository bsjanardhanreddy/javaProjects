package com.jsp.integration.dto;

public class AppResponseDTO 
{
	private String status;
	private String errorMessage;
	private Object data;
	public AppResponseDTO(String status, String errorMessage, Object data) 
	{
		this.status = status;
		this.errorMessage = errorMessage;
		this.data = data;
	}
	
	@Override
	public String toString() 
	{
		return "AppResponseDTO [status=" + status + ", errorMessage=" + errorMessage + ", data=" + data + "]";
	}

	public Object getData() 
	{
		return data;
	}

	public String getStatus() 
	{
		return status;
	}

	public String getErrorMessage() 
	{
		return errorMessage;
	}

}
