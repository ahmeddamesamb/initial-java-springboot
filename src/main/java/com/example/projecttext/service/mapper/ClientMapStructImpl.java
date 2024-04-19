package com.example.projecttext.service.mapper;

import com.example.projecttext.dto.ClientDto;
import com.example.projecttext.model.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientMapStructImol implements ClientMapStruct{
    private final ModelMapper modelMapper;

    public ClientMapStructImol(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientDto toDto(Client client) {
        return modelMapper.map(client,ClientDto.class);
    }

    @Override
    public Client toEntity(ClientDto clientDto) {
        return modelMapper.map(clientDto,Client.class);
    }
}
