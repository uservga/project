package com.example.controller;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.dto.LoginDto;
import com.example.dto.RegistrationDto;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.util.Collections;

/**
 * Class controller for manage login/registration users
 */

@RestController
@RequestMapping("/main-page/authorization")
public class AuthorizationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationDto registrationDto){
        if(userRepository.existsByUsername(registrationDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByEmail(registrationDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setName(registrationDto.getName());
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));

        Role roles = roleRepository.findByName("ADMIN").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/main-page/authorization/login");
        redirectView.setStatusCode(HttpStatus.SEE_OTHER);

        return new ResponseEntity<>(redirectView, HttpStatus.OK);
    }
}