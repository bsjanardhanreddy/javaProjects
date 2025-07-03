package com.jsp.aws.files.repository;

import com.jsp.aws.files.entity.S3BucketConfigCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface S3BucketConfigRepository extends JpaRepository<S3BucketConfigCredentials, Long>
{
    S3BucketConfigCredentials findTopByOrderByIdDesc();
    S3BucketConfigCredentials findTopByOrderByIdAsc();
}
