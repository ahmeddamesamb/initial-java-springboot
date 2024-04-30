package com.example.projecttext.service;

import com.example.projecttext.dto.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClientService {

    ClientDto save(ClientDto clientDto) throws Exception;

    Optional<ClientDto> update(ClientDto clientDto) throws Exception;

    Page<ClientDto> findAll(Pageable pageable) throws Exception;

    Optional<ClientDto> findOne(Long id) throws Exception;

    String delete(Long id) throws Exception;

}
