package com.rolidev.apirest.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rolidev.apirest.models.Role;

public interface RoleRepository extends JpaRepository<Role, String>{
    boolean existsByName(String name);
}