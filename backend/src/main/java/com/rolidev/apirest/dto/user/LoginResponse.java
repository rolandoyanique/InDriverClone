package com.rolidev.apirest.dto.user;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private CreateUserResponse user;
}
