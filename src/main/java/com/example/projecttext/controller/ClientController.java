package com.example.projecttext.controller;

import com.example.projecttext.dto.ClientDto;
import com.example.projecttext.service.ClientService;
import com.example.projecttext.utlis.Endpoints;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(Endpoints.URL_APP)
@CrossOrigin(origins = "", allowedHeaders = "*")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping(Endpoints.URL_CLIENT)
    public Page<ClientDto> getAllClient(Pageable pageable) {
        return clientService.findAll(pageable);
    }

    @PutMapping(Endpoints.URL_ONE_CLIENT)
    public Optional<ClientDto> updateClient(ClientDto clientDto) {
        return clientService.update(clientDto);
    }


    @GetMapping(Endpoints.URL_ONE_CLIENT)
    public Optional<ClientDto> getClient(Long id) {
        return clientService.findOne(id);
    }

    @PostMapping(Endpoints.URL_CLIENT)
    public ClientDto createClient(ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @DeleteMapping(Endpoints.URL_ONE_CLIENT)
    public String deleteClient(Long id) {
        return clientService.delete(id);
    }

}
