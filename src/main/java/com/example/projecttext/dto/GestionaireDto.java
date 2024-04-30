package com.example.projecttext.dto;

import com.example.projecttext.model.ERole;
import lombok.Data;

@Data
public class GestionaireDto {
    private Long id;
    private String telephone;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private ERole ERole;

}
