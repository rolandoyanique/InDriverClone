package com.rolidev.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rolidev.apirest.models.UserHashRoles;
import com.rolidev.apirest.models.id.UserRoleId;

public interface UserHasRolesRepository extends JpaRepository<UserHashRoles,UserRoleId>{
}
