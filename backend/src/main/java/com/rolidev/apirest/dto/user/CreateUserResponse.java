package com.rolidev.apirest.dto.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rolidev.apirest.dto.role.RoleDTO;

import lombok.Data;

@Data
public class CreateUserResponse {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String imagen;

    @JsonProperty("notification_token")
    private String notificationToken;

    List<RoleDTO> roles;
}
