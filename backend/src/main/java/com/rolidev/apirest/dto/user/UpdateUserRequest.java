package com.rolidev.apirest.dto.user;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String name;
    private String lastname;
    private String phone;
    private MultipartFile file;

}
