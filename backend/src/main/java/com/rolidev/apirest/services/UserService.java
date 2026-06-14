package com.rolidev.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rolidev.apirest.models.User;
import com.rolidev.apirest.dto.user.CreateUserRequest;
import com.rolidev.apirest.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User create(CreateUserRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("El correo ya se encuentra registrado");
        }
        User user = new User();
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }
}
