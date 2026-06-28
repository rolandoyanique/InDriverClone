package com.rolidev.apirest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rolidev.apirest.models.User;

public interface UserRepository extends JpaRepository<User,Long>{
    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.userHashRoles uhr LEFT JOIN FETCH uhr.role WHERE u.email = :email")
    Optional<User> findByEmail(String email);
}
