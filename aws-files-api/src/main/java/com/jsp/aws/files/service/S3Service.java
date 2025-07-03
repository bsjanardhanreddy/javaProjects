package com.jsp.aws.files.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.services.s3.S3Client;


public interface S3Service 
{

	public abstract String uploadFile(MultipartFile file) throws IOException; 
	public byte[] downloadFile(String key) ;
	public String deleteFile(String key) ;
}
