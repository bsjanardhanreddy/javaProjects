package com.jsp.integration.dto;

public class DataSourceDTO 
{
	private String userName;
	private String password;
	private String dbName;
	private String hostName;
	private String portNumber;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}
	@Override
	public String toString() 
	{
		return "DataSourceDTO [userName=" + userName + ", password=" + password + ", dbName=" + dbName + ", hostName="
				+ hostName + ", portNumber=" + portNumber + "]";
	}
	

}
