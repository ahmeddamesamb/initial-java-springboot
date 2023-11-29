package com.example.projecttext.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    private String email;    
    private String password;
    private String nom;
    private String prenom;
    private String telephone;

}
