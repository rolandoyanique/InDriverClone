package com.rolidev.apirest.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.rolidev.apirest.dto.user.CreateUserRequest;
import com.rolidev.apirest.models.User;
import com.rolidev.apirest.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/users")
public class UserControllers {

    @Autowired
    private UserService userService;

    @PostMapping({"", "/"})
    public ResponseEntity<User> create(@RequestBody CreateUserRequest request){
        User user=userService.create(request);
        return ResponseEntity.ok(user);
    }
}
