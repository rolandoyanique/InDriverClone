package com.rolidev.apirest.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
import com.rolidev.apirest.dto.user.LoginRequest;
import com.rolidev.apirest.dto.user.LoginResponse;
import com.rolidev.apirest.dto.user.UpdateUserRequest;
import com.rolidev.apirest.repositories.RoleRepository;
import com.rolidev.apirest.repositories.UserRepository;
import com.rolidev.apirest.utils.JwtUtil;
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

    @Autowired
    private JwtUtil jwtUtil;

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
        response.setName(saveUser.getName());
        response.setLastname(saveUser.getLastname());
        response.setImagen(saveUser.getImage());
        response.setPhone(saveUser.getPhone());
        response.setEmail(saveUser.getEmail());

        List<Role> roles = roleRepository.findAllByUserHashRoles_User_Id(saveUser.getId());
        List<RoleDTO> roleDTOs = roles.stream().map(
            role -> new RoleDTO(role.getId(),role.getName(),role.getImage(),role.getRoute())
        ).toList();
        response.setRoles(roleDTOs);
        return response;
    }
    
    @Transactional
    public LoginResponse login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("el Email o el Password no son validos"));
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("el Email o el Password no son validos");
        }
        String token = jwtUtil.generateToken(user);

        List<Role> roles = roleRepository.findAllByUserHashRoles_User_Id(user.getId());
        List<RoleDTO> roleDTOs = roles.stream().map(
            role -> new RoleDTO(role.getId(),role.getName(),role.getImage(),role.getRoute())
        ).toList();

        CreateUserResponse userResponse = new CreateUserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setLastname(user.getLastname());
        userResponse.setImagen(user.getImage());
        userResponse.setPhone(user.getPhone());
        userResponse.setEmail(user.getEmail());
        userResponse.setRoles(roleDTOs);

        LoginResponse response = new LoginResponse();
        response.setToken("Bearer " + token);
        response.setUser(userResponse);
        return response;
    }
       @Transactional
    public CreateUserResponse findById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("el Email o el Password no son validos"));
        List<Role> roles = roleRepository.findAllByUserHashRoles_User_Id(user.getId());
        List<RoleDTO> roleDTOs = roles.stream().map(
            role -> new RoleDTO(role.getId(),role.getName(),role.getImage(),role.getRoute())
        ).toList();

        CreateUserResponse userResponse = new CreateUserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setLastname(user.getLastname());
        userResponse.setImagen(user.getImage());
        userResponse.setPhone(user.getPhone());
        userResponse.setEmail(user.getEmail());
        userResponse.setRoles(roleDTOs);
        return userResponse;
    }
    @Transactional
    public CreateUserResponse updateUserWithImage(Long id, UpdateUserRequest request) throws IOException{
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("el Email o el Password no son validos"));

        if(request.getName() != null){
            user.setName(request.getName());
        }

        if(request.getLastname() != null){
            user.setLastname(request.getLastname());
        }

        if(request.getPhone() != null){
            user.setPhone(request.getPhone());
        }

        if(request.getFile() !=null && !request.getFile().isEmpty()){
            String uploadDir = "uploads/users/"+user.getId();
            String filename = request.getFile().getOriginalFilename();
            String filePath = Paths.get(uploadDir,filename).toString();
            Files.createDirectories(Paths.get(uploadDir));
            Files.copy(request.getFile().getInputStream(),Paths.get(filePath),StandardCopyOption.REPLACE_EXISTING);
            user.setImage("/"+filePath.replace("\\","/"));
        }

        userRepository.save(user);

        List<Role> roles = roleRepository.findAllByUserHashRoles_User_Id(user.getId());
        List<RoleDTO> roleDTOs = roles.stream().map(
            role -> new RoleDTO(role.getId(),role.getName(),role.getImage(),role.getRoute())
        ).toList();

        CreateUserResponse userResponse = new CreateUserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setLastname(user.getLastname());
        userResponse.setImagen(user.getImage());
        userResponse.setPhone(user.getPhone());
        userResponse.setEmail(user.getEmail());
        userResponse.setRoles(roleDTOs);
        return userResponse;
    }
}