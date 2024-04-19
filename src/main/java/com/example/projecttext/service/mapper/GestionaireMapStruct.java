package com.example.projecttext.service.mapper;

import com.example.projecttext.dto.GestionaireDto;
import com.example.projecttext.model.Gestionaire;
import org.modelmapper.ModelMapper;

public interface GestionaireMapStruct {

    GestionaireDto toDto(Gestionaire gestionaire);

    Gestionaire toEntity(GestionaireDto gestionaireDto);
}
