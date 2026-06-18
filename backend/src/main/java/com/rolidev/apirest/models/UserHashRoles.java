package com.rolidev.apirest.models;

import org.hibernate.annotations.ManyToAny;

import com.rolidev.apirest.models.id.UserRoleId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_has_roles")
public class UserHashRoles {
    
    @EmbeddedId
    private UserRoleId id= new UserRoleId();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "id_rol")
    private Role role;


    public UserHashRoles(){}
    public UserHashRoles(User user,Role role){
        this.user=user;
        this.role=role;
        this.id = new UserRoleId(user.getId(),role.getId());
    }
}
