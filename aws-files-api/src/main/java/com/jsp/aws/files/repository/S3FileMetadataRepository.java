package com.jsp.aws.files.repository;

import com.jsp.aws.files.entity.S3FileMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface S3FileMetadataRepository extends JpaRepository<S3FileMetadata, Long> 
{
	
	S3FileMetadata findByKey(String key);
}
