package com.rolidev.apirest.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name="roles")
public class Role {
    @Id
    @Column(length=36)
    private String id=UUID.randomUUID().toString();

    @Column(length=36, unique=true, nullable=false)
    private String name;

    @Column(length=255, nullable=false)
    private String image;

    @Column(length=255, nullable=false)
    private String route;

    @Column(name="created_at", nullable=false, updatable=false)
    private LocalDateTime createAt = LocalDateTime.now();

    @Column(name="update_at", nullable=false)
    private LocalDateTime updateAt = LocalDateTime.now();

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserHashRoles> userHashRoles = new HashSet<>();

    public Role(){}

    @PreUpdate
    public void onUpdate(){
        this.updateAt=LocalDateTime.now();
    }
}