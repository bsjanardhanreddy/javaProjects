package com.jsp.aws.files.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.aws.files.entity.S3BucketConfigCredentials;
import com.jsp.aws.files.service.S3BucketConfigService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/s3-config")
@RequiredArgsConstructor
public class S3BucketConfigController 
{

    private final S3BucketConfigService configService;

    @PostMapping("/save")
    public ResponseEntity<String> saveConfig(@RequestBody S3BucketConfigCredentials config) 
    {
        configService.saveConfig(config);
        return ResponseEntity.ok("S3 config saved successfully");
    }

    @GetMapping("/latest")
    public ResponseEntity<S3BucketConfigCredentials> getLatestConfig() 
    {
        return ResponseEntity.ok(configService.getLatestConfig());
    }
    
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<S3BucketConfigCredentials> getById(@PathVariable Long id) 
    {
        return ResponseEntity.ok(configService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<S3BucketConfigCredentials>> getAllConfigs() 
    {
        return ResponseEntity.ok(configService.getAllConfigs());
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateConfig(@PathVariable Long id, @RequestBody S3BucketConfigCredentials newConfig)
    {
        configService.updateConfig(id, newConfig);
        return ResponseEntity.ok("Config updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteConfig(@PathVariable Long id) 
    {
        configService.deleteConfig(id);
        return ResponseEntity.ok("Config deleted with id: " + id);
    }

}
