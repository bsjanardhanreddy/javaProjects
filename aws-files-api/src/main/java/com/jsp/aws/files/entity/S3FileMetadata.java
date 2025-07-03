package com.jsp.aws.files.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class S3FileMetadata 
{

   
    @Column(name = "`key`")
    @Id
    private String key;
    private String fileName;
    private LocalDateTime uploadedAt;

}
