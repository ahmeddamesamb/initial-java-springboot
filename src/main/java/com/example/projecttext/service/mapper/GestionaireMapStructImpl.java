package com.example.projecttext.service.mapper;

import com.example.projecttext.dto.GestionaireDto;
import com.example.projecttext.model.Gestionaire;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class GestionaireMapStructImpl implements GestionaireMapStruct{
    private final ModelMapper modelMapper;

    public GestionaireMapStructImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public GestionaireDto toDto(Gestionaire gestionaire) {
        return modelMapper.map(gestionaire,GestionaireDto.class);
    }

    @Override
    public Gestionaire toEntity(GestionaireDto gestionaireDto) {
        return modelMapper.map(gestionaireDto,Gestionaire.class);
    }
}
