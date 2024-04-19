package com.example.projecttext.service.mapper;

import com.example.projecttext.dto.ClientDto;
import com.example.projecttext.model.Client;

public interface ClientMapStruct {
    ClientDto toDto (Client client);
    Client toEntity(ClientDto clientDto);
}
