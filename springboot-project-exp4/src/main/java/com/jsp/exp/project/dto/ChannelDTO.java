package com.jsp.exp.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChannelDTO 
{
	private String configName;
	private String type;
	private String region;
	private String apiKey;
	private String securityKey;
	private boolean isActive;

}
