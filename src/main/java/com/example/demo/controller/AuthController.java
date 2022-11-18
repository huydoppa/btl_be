package com.example.demo.controller;

import com.example.demo.enitity.User;
import com.example.demo.payload.ApiResponse;
import com.example.demo.payload.AuthRequest;
import com.example.demo.payload.LoginResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CustomUserDetails;
import com.example.demo.security.JwtTokenProvIder;
import com.example.demo.serivce.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvIder jwtTokenProvIder;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserSevice userSevice;
    @PostMapping("/signup")
    public ApiResponse signUp(@RequestBody AuthRequest authRequest){
        if(userSevice.checkExistUsername(authRequest.getUsername())){
            return new ApiResponse(1, "username is already used");
        }

        String username = authRequest.getUsername();
        String password = passwordEncoder.encode(authRequest.getPassword());
        String phone = authRequest.getPhone();
        String email = authRequest.getEmail();

        User user = new User(username, password,phone,email);

        userRepository.save(user);

        return new ApiResponse(0);
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvIder.generateToken((CustomUserDetails) authentication.getPrincipal());

        User user = userSevice.getUserByUsername(authRequest.getUsername());
        return new LoginResponse(token, user);
    }
}
