package com.example.demo.repository;

import com.example.demo.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String phone);

    Optional<User> findById(Long Id);

    @Query("select u from User u where u.username = ?1")
    User checkExistUserName(String username);

    @Query("select u from User u")
    ArrayList<User> getAllUser ();
}