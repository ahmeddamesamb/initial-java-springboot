package com.example.projecttext.service;

import com.example.projecttext.model.User;
import com.example.projecttext.payload.request.AuthenticationRequest;
import com.example.projecttext.payload.response.AuthenticationResponse;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(long id);

    AuthenticationResponse createUser(User user);

    AuthenticationResponse updateUser(long id, AuthenticationRequest userAuthenticationRequest);

    AuthenticationResponse deleteUser(long id);


}
