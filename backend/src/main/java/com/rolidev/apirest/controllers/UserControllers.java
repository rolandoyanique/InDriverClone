package com.rolidev.apirest.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.rolidev.apirest.dto.user.CreateUserRequest;
import com.rolidev.apirest.dto.user.CreateUserResponse;
import com.rolidev.apirest.dto.user.LoginRequest;
import com.rolidev.apirest.dto.user.LoginResponse;
import com.rolidev.apirest.models.User;
import com.rolidev.apirest.services.UserService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/users")
public class UserControllers {

    @Autowired
    private UserService userService;

    @PostMapping({"", "/"})
    public ResponseEntity<CreateUserResponse> create(@RequestBody CreateUserRequest request){
        CreateUserResponse user=userService.create(request);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try{
            CreateUserResponse response=userService.findById(id);
            return ResponseEntity.ok(response);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message",e.getMessage(),"statusCode",HttpStatus.NOT_FOUND.value()));
        }
        
    }
}
