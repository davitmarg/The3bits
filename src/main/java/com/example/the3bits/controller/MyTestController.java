package com.example.the3bits.controller;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.example.the3bits.facade.user.UserFacade;
import com.example.the3bits.facade.user.model.UserResponseModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class MyTestController {

    private final UserFacade userFacade;


    public MyTestController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PutMapping(value = "/testUpload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadImage(@RequestPart MultipartFile userImage) throws IOException {

        String ACCESS_KEY = "AKIAR6HC55A56BQGZIWD";
        String SECRET_ACCESS_KEY = "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";

        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY,SECRET_ACCESS_KEY);
        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(credentials);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(awsStaticCredentialsProvider)
                .withRegion(Regions.US_EAST_2)
                .build();


        InputStream inputStream = userImage.getInputStream();
        PutObjectRequest requestFile = new PutObjectRequest("the3bits", userImage.getOriginalFilename(), inputStream, new ObjectMetadata());
        requestFile.withCannedAcl(CannedAccessControlList.PublicRead);
        PutObjectResult putObjectResult = s3Client.putObject(requestFile);
        String pictureURL = s3Client.getUrl("the3bits", userImage.getOriginalFilename()).toExternalForm();
        return ResponseEntity.ok(pictureURL);
    }


    @GetMapping("/secure")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public String get() {
        return "OK!!!!!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String foo() {
        return "OK!!!!!";
    }

    @GetMapping("/ashot")
    public String ghazaryan() {
        return "Ashot Ghazaryan";
    }
}
