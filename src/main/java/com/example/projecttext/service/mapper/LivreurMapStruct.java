package com.example.projecttext.service.mapper;

import com.example.projecttext.dto.LivreurDto;
import com.example.projecttext.model.Livreur;
import org.modelmapper.ModelMapper;

public interface LivreurMapStruct {

    LivreurDto toDto(Livreur livreur);

    Livreur toEntity(LivreurDto livreurDto);
}
