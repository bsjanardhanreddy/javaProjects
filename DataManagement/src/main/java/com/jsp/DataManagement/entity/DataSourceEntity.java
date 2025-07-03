package com.jsp.DataManagement.entity;

import java.math.BigInteger;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//The code is referring to an existing table named datasource_master not creating table
@Table(name="datasource_master")
public class DataSourceEntity 
{
	@Id
	@Column(name="alt_key")
	private BigInteger altKey;
	@Column(name="db_name")
	private String dbName;
	@Column(name="db_password")
	private String dbPassword;
	@Column(name="host_name")
	private String hostName;
	@Column(name="port_number")
	private String portNumber;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="modified_date")
	private Date modifiedDate;
	
	public BigInteger getAltKey() {
		return altKey;
	}
	public void setAltKey(BigInteger altKey) {
		this.altKey = altKey;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	@Override
	public String toString() 
	{
		return "DataSourceEntity [altKey=" + altKey + ", dbName=" + dbName + ", dbPassword=" + dbPassword
				+ ", hostName=" + hostName + ", portNumber=" + portNumber + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + "]";
	}
	
	
	
}
