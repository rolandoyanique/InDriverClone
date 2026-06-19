package com.rolidev.apirest.controllers;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.rolidev.apirest.services.UserService;
import com.rolidev.apirest.models.User;
import com.rolidev.apirest.dto.user.CreateUserRequest;
import com.rolidev.apirest.dto.user.CreateUserResponse;
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody CreateUserRequest request){
        try{
            CreateUserResponse user=userService.create(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message",e.getMessage(),"statusCode",HttpStatus.BAD_REQUEST.value()));
        }
        
    }
}
