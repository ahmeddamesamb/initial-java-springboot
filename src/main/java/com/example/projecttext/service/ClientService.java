package com.example.projecttext.service;

import com.example.projecttext.dto.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClientService {
    ClientDto save(ClientDto clientDto);

    Optional<ClientDto> update(ClientDto clientDto);

    Page<ClientDto> findAll(Pageable pageable);

    Optional<ClientDto> findOne(Long id);

    String delete(Long id);

}
