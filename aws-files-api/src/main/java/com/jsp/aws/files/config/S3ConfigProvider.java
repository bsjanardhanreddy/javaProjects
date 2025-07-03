package com.jsp.aws.files.config;

import org.springframework.stereotype.Component;

import com.jsp.aws.files.repository.S3BucketConfigRepository;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;
import software.amazon.awssdk.services.s3.model.NoSuchBucketException;

@Component
@RequiredArgsConstructor
public class S3ConfigProvider
{


    public S3Client getS3Client(String region,String accessKey,String secretKey ) 
    {
        return S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)))
                .build();
    }


    public void checkOrCreateBucket(S3Client s3Client, String bucketName) 
	{
		try 
		{
			s3Client.headBucket(HeadBucketRequest.builder().bucket(bucketName).build());
		} 
		catch (NoSuchBucketException e)
		{
			s3Client.createBucket(CreateBucketRequest.builder().bucket(bucketName).build());
		}
	}
}
