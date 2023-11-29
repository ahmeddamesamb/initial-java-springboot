package com.example.projecttext.utlis;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    OK(200, "Sucess"),
    KO(400, "Echec"),
    UNAUTHORIZED(401, "Vous n'etes pas autorisé à acceder"),
    BAD_REQUEST(400, "Données incorrectes"),
    NOT_FOUND_USER(404, "L'utilisateur n'existe pas"),
    NOT_FOUND_OTHER_USER(404, "L'agent n'existe pas"),
    NOT_FOUND_DEMANDE(404, "La demande n'existe pas");

    private final Integer code;
    private final String message;
}
