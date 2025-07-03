package com.jsp.aws.files.service;

import com.jsp.aws.files.entity.S3BucketConfigCredentials;

import java.util.List;

public interface S3BucketConfigService 
{
    void saveConfig(S3BucketConfigCredentials config);
    S3BucketConfigCredentials getLatestConfig();
    S3BucketConfigCredentials getById(Long id);
    List<S3BucketConfigCredentials> getAllConfigs();
    void updateConfig(Long id, S3BucketConfigCredentials newConfig);
    void deleteConfig(Long id);
}
