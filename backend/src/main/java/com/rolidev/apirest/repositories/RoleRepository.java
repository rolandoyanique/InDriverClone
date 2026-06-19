package com.rolidev.apirest.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rolidev.apirest.models.Role;

public interface RoleRepository extends JpaRepository<Role, String>{
    boolean existsByName(String name);

    List<Role> findAllByUserHashRoles_User_Id(Long idUser);
}