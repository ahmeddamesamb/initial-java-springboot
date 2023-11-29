package com.example.projecttext.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.projecttext.payload.request.AuthenticationRequest;
import com.example.projecttext.payload.response.AuthenticationResponse;
import com.example.projecttext.utlis.Endpoints;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.URL_APP)
@RequiredArgsConstructor
public class AuthenticationController {
     private final AuthenticationService authenticationService;
    @PostMapping(Endpoints.AUTHENTICATE)
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
