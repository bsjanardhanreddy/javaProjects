package com.jsp.WorkFlowInfo.dto;

public class UpdateWfDTO
{
	private String version;
	private String wfCode;
	private String status;
	public String getWfId() {
		return version;
	}
	public void setWfId(String version) {
		this.version = version;
	}
	public String getWfCode() {
		return wfCode;
	}
	public void setWfCode(String wfCode) {
		this.wfCode = wfCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
