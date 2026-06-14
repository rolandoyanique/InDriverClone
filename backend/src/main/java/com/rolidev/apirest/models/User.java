package com.rolidev.apirest.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255,nullable = false)
    private String name;

    @Column(length = 255,nullable = false)
    private String lastname;

    @Column(length = 255,nullable = false,unique = true)
    private String email;

    @Column(length = 13,nullable = false)
    private String phone;

    @Column(length = 255,nullable = true)
    private String image;

    @Column(length = 255,nullable = false)
    private String password;

    @Column(name="notification_token",length = 255,nullable = true)
    private String notificationToken;

    @Column(name="created_at", nullable=false, updatable=false)
    private LocalDateTime createAt = LocalDateTime.now();

    @Column(name="update_at", nullable=false)
    private LocalDateTime updateAt = LocalDateTime.now();

    public User(){}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNotificationToken() { return notificationToken; }
    public void setNotificationToken(String notificationToken) { this.notificationToken = notificationToken; }

    public LocalDateTime getCreateAt() { return createAt; }
    public void setCreateAt(LocalDateTime createAt) { this.createAt = createAt; }

    public LocalDateTime getUpdateAt() { return updateAt; }
    public void setUpdateAt(LocalDateTime updateAt) { this.updateAt = updateAt; }

    @PreUpdate
    public void onUpdate(){
        this.updateAt=LocalDateTime.now();
    }
}
