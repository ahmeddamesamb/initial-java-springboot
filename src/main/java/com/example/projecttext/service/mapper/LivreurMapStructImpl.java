package com.example.projecttext.service.mapper;

import com.example.projecttext.dto.LivreurDto;
import com.example.projecttext.model.Livreur;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LivreurMapStructImpl implements LivreurMapStruct{
    private final ModelMapper modelMapper;

    public LivreurMapStructImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public LivreurDto toDto(Livreur livreur) {
        return modelMapper.map(livreur,LivreurDto.class);
    }

    @Override
    public Livreur toEntity(LivreurDto livreurDto) {
        return modelMapper.map(livreurDto,Livreur.class);
    }
}
