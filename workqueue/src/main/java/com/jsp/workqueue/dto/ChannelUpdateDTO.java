package com.jsp.workqueue.dto;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChannelUpdateDTO 
{
	private BigInteger altKey;
	private String configName;
	private String apiKey;
	private String secretKey;

}
