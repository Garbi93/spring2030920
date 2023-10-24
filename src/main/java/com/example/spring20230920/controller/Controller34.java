package com.example.spring20230920.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@Controller
@RequestMapping("main34")
@RequiredArgsConstructor
public class Controller34 {

    private final S3Client s3Client;

    @Value("${aws.bucketName}")
    private String bucketName; // 버킷 이름은 숨겨두자

    @GetMapping("sub1")
    public void method1() {

    }

    @PostMapping("sub2")
    public void method2(MultipartFile file) throws IOException {

        if(file != null && file.getSize() >0) {
            String key ="temp/" + file.getOriginalFilename(); // 파일 경로

            PutObjectRequest objectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .acl(ObjectCannedACL.PUBLIC_READ) // 누구든지 볼수 있게 권한을 주는것을 중간에 넣어준다.
                    .key(key)
                    .build();

            s3Client.putObject(objectRequest,
                    RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

        }
    }
}
