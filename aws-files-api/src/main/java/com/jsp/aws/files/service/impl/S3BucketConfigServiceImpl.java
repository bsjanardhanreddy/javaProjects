package com.jsp.aws.files.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jsp.aws.files.entity.S3BucketConfigCredentials;
import com.jsp.aws.files.repository.S3BucketConfigRepository;
import com.jsp.aws.files.service.S3BucketConfigService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class S3BucketConfigServiceImpl implements S3BucketConfigService {

    private final S3BucketConfigRepository configRepository;

    @Override
    public void saveConfig(S3BucketConfigCredentials config) {
        configRepository.save(config);
    }

    @Override
    public S3BucketConfigCredentials getLatestConfig() 
    {
        return configRepository.findTopByOrderByIdDesc();
    }

    @Override
    public S3BucketConfigCredentials getById(Long id) {
        return configRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Config not found with id: " + id));
    }

    @Override
    public List<S3BucketConfigCredentials> getAllConfigs() {
        return configRepository.findAll();
    }

    @Override
    public void updateConfig(Long id, S3BucketConfigCredentials newConfig)
    {
        S3BucketConfigCredentials existing = configRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Config not found with id: " + id));

        existing.setAccessKey(newConfig.getAccessKey());
        existing.setSecretKey(newConfig.getSecretKey());
        existing.setRegion(newConfig.getRegion());
        existing.setBucketName(newConfig.getBucketName());

        configRepository.save(existing);
    }

    @Override
    public void deleteConfig(Long id) 
    {
        S3BucketConfigCredentials config = configRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Config not found with id: " + id));
        configRepository.delete(config);
    }
}
