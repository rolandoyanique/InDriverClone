package com.rolidev.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rolidev.apirest.models.User;
import com.rolidev.apirest.models.UserHashRoles;
import com.rolidev.apirest.models.Role;
import com.rolidev.apirest.dto.role.RoleDTO;
import com.rolidev.apirest.dto.user.CreateUserRequest;
import com.rolidev.apirest.dto.user.CreateUserResponse;
import com.rolidev.apirest.repositories.RoleRepository;
import com.rolidev.apirest.repositories.UserRepository;
import com.rolidev.apirest.repositories.UserHasRolesRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserHasRolesRepository userHasRolesRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public CreateUserResponse create(CreateUserRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("El correo ya se encuentra registrado");
        }
        User user = new User();
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        String encryptedPassword = passwordEncoder.encode(request.getPassword());

        user.setPassword(encryptedPassword);
        User saveUser = userRepository.save(user);
        Role clientRole=roleRepository.findById("CLIENT").orElseThrow(
            () -> new RuntimeException("El rol de cliente no existe")
        );

        UserHashRoles userHashRoles = new UserHashRoles(saveUser,clientRole);
        userHasRolesRepository.save(userHashRoles);

        CreateUserResponse response=new CreateUserResponse();

        response.setId(saveUser.getId());
        response.setName(saveUser.getName());;
        response.setLastname(saveUser.getLastname());
        response.setImagen(saveUser.getImage());
        response.setPhone(saveUser.getPhone());

        List<Role> roles = roleRepository.findAllByUserHashRoles_User_Id(saveUser.getId());
        List<RoleDTO> roleDTOs = roles.stream().map(
            role -> new RoleDTO(role.getId(),role.getName(),role.getImage(),role.getRoute())
        ).toList();
        response.setRoles(roleDTOs);
        return response;
    }
}
