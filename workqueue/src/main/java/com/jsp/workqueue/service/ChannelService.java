package com.jsp.workqueue.service;

import java.math.BigInteger;
import java.util.List;

import com.jsp.workqueue.dto.AppResponceDTO;
import com.jsp.workqueue.dto.ChannelDTO;
import com.jsp.workqueue.dto.ChannelUpdateDTO;

public interface ChannelService
{
	 AppResponceDTO  processCreate(ChannelDTO ChannelDTO);
	 AppResponceDTO  getAll();
	 AppResponceDTO  getById(BigInteger altKey);
	 AppResponceDTO  getByNameAndType(String configName,String type);
	 AppResponceDTO  getChannelConfigs(List<String> configName);
	 AppResponceDTO  getChannelByRegionAndConfigName(String region,String configName);
	 AppResponceDTO  updateChannel(ChannelUpdateDTO channelUpdateDTO);
	 AppResponceDTO  updateChannelStatus(BigInteger altKey,boolean status);
	 
	 
	 
}
