package com.rolidev.apirest.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.rolidev.apirest.services.UserService;
import com.rolidev.apirest.models.User;
import com.rolidev.apirest.dto.user.CreateUserRequest;
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping({"", "/"})
    public ResponseEntity<User> create(@RequestBody CreateUserRequest request){
        User user=userService.create(request);
        return ResponseEntity.ok(user);
    }
}
