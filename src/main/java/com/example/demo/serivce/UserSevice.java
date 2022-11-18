package com.example.demo.serivce;

import com.example.demo.enitity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserSevice {
    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Boolean checkExistUsername(String username){
        return userRepository.checkExistUserName(username) != null;
    }

    public ArrayList<User> getAllUser(){
        return userRepository.getAllUser();
    }
}
