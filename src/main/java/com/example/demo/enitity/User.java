package com.example.demo.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @JsonIgnore
    private String password;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String role;
    public User() {
    }

    public User(Long Id, String phone, String email, String password, String username,String role) {
        this.Id = Id;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }
    public User(String username, String password, String phone, String email, String role){
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}