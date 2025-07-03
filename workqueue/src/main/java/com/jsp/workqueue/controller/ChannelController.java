package com.jsp.workqueue.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.workqueue.dto.AppResponceDTO;
import com.jsp.workqueue.dto.ChannelDTO;
import com.jsp.workqueue.dto.ChannelUpdateDTO;
import com.jsp.workqueue.service.ChannelService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ChannelController 
{
//	@Autowired
	ChannelService channelService;

//	@RequestMapping(value = "/create",method = RequestMethod.POST)
	@PostMapping(value = "/create")
	public @ResponseBody AppResponceDTO createChannel(@RequestBody ChannelDTO ChannelDTO) 
	{
		return channelService.processCreate(ChannelDTO);
	}
	
	@GetMapping(value="/get-all-channels")
	public @ResponseBody AppResponceDTO getAllChannels()
	{
		return channelService.getAll();
	}
	
	@GetMapping(value="/get-by-id/{id}")
	public @ResponseBody AppResponceDTO getByID(@PathVariable(name = "id") BigInteger altKey) 
	{
		return channelService.getById(altKey);
	}
	
	@GetMapping(value="/getByNameAndType/{configName}/{type}")
	public @ResponseBody AppResponceDTO getByConfigNameAndType(@PathVariable(name = "configName") String configName,@PathVariable(name = "type") String type) 
	{
		return channelService.getByNameAndType(configName, type);
	}
	
	@PostMapping(value="/getChannelsByConfigNames")
	public @ResponseBody AppResponceDTO getByConfigNameAndType(@RequestBody List<String> configNames) 
	{
		return channelService.getChannelConfigs(configNames);
	}
	
	@GetMapping(value="/getByRegionAndConfigName")
	public @ResponseBody AppResponceDTO getByRegionAndConfigName(@RequestHeader("region") String region,@RequestHeader("configName") String configName) 
	{
		return channelService.getChannelByRegionAndConfigName(region, configName);
	}
	
	@PutMapping(value="/update")
	public @ResponseBody AppResponceDTO updateChannel(@RequestBody ChannelUpdateDTO updateDTO) 
	{
		return channelService.updateChannel(updateDTO);
	}
	
	@PutMapping(value="/update/status")
	public @ResponseBody AppResponceDTO updateChannelStatusbyId(@RequestParam BigInteger altKey,@RequestParam boolean status) 
	{
		return channelService.updateChannelStatus(altKey, status);
	}
	
}
