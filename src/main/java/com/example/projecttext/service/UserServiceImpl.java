package com.example.projecttext.service;

import com.example.projecttext.model.ERole;
import com.example.projecttext.model.User;
import com.example.projecttext.payload.request.AuthenticationRequest;
import com.example.projecttext.payload.response.AuthenticationResponse;

import java.util.List;
import java.util.Optional;


import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.projecttext.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

   private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


        @Override
    public User getUserById(long id) {
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("l'user que vous checher n existe pas!!!");
        }
    }
        @Override
    public AuthenticationResponse createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setERole(ERole.ADMIN);
        userRepository.save(user);
        return new AuthenticationResponse();
    }

    @Override
    public AuthenticationResponse updateUser(long id, AuthenticationRequest userRequestAuthenticationRequest) {

        User user = userRepository
            .findById(id)
            .orElseThrow(() ->
                new RuntimeException(
                    "La tentative de mise a jour du user na pas aboutit"
                )
            );
//        user.setNom(userRequestAuthenticationRequest.getNom());
//        user.setPrenom(userRequestAuthenticationRequest.getPrenom());
        user.setEmail(userRequestAuthenticationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestAuthenticationRequest.getPassword()));
//        user.setTelephone(userRequestAuthenticationRequest.getTelephone());
        user.setERole(ERole.ADMIN);
         userRepository.save(user);
        return new AuthenticationResponse();
    }

    @Override
    public AuthenticationResponse deleteUser(long id) {
        var userOptional=userRepository.findById(id);
        if (userOptional.isPresent()){
            userRepository.deleteById(id);
            return new AuthenticationResponse();
        }
        return new AuthenticationResponse();
     }
    
}
