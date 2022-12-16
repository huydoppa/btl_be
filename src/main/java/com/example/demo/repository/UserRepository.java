package com.example.demo.repository;

import com.example.demo.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String phone);

    Optional<User> findById(Long Id);

    Boolean existsByUsername(String username);

}