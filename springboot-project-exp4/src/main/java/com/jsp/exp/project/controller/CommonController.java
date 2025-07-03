package com.jsp.exp.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.exp.project.dto.AppResponceDTO;
import com.jsp.exp.project.dto.ChannelDTO;
import com.jsp.exp.project.service.CommonService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CommonController 
{
    CommonService commonService;
    
	@PostMapping(value = "/create")
	public @ResponseBody AppResponceDTO createChannel(@RequestBody ChannelDTO ChannelDTO) 
	{
		return commonService.processCreate(ChannelDTO);
	}
	
	 @GetMapping("/getchannels")
	 public @ResponseBody AppResponceDTO getAllChannels() 
	 {
	        AppResponceDTO response = commonService.getChannels();
	        return response;
	 }
}
