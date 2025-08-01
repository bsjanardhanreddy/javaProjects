package com.jsp.aws.files.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.aws.files.entity.S3FileMetadata;
import com.jsp.aws.files.repository.S3FileMetadataRepository;
import com.jsp.aws.files.service.S3Service;

import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RestController
@RequestMapping("/api/s3")
@RequiredArgsConstructor
public class S3Controller 
{

    private final S3Service s3Service;
    private final S3FileMetadataRepository s3FileMetadataRepository;

    // Upload endpoint - uploads file to S3 and stores metadata
    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        String key = s3Service.uploadFile(file);
        return ResponseEntity.ok("File uploaded with key: " + key);
    }

    // Download endpoint - downloads file from S3 using the key
    @GetMapping("/download/{key}")
    public ResponseEntity<byte[]> download(@PathVariable String key) {
        byte[] data = s3Service.downloadFile(key);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + key)
                .body(data);
    }

    // Delete endpoint - deletes file from S3 and metadata from DB
    @DeleteMapping("/delete/{key}")
    public ResponseEntity<String> delete(@PathVariable String key) {
        return ResponseEntity.ok(s3Service.deleteFile(key));
    }

    // New endpoint - fetch extracted text from DB for a given file key
//    @GetMapping("/text/{key}")
//    public ResponseEntity<String> getExtractedText(@PathVariable String key) 
//    {
//        S3FileMetadata metadata = s3FileMetadataRepository.findByKey(key);
//        if (metadata != null && metadata.getExtractedText() != null) 
//        {
//            return ResponseEntity.ok(metadata.getExtractedText());
//        } 
//        else
//        {
//            return ResponseEntity.status(404).body("Extracted text not found for key: " + key);
//        }
//    }
}
