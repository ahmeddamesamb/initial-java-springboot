package com.example.projecttext.controller;

import com.example.projecttext.dto.ClientDto;
import com.example.projecttext.service.ClientService;
import com.example.projecttext.utlis.Endpoints;
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


//    @GetMapping()
//    public Page<ClientDto> findAll() {
//        return clientService.findAll();
//    }

//    @PutMapping(Endpoints.URL_ONE_ETUDIANT)
//    public EtudiantResponse updateEtudiant(@PathVariable Long id, @RequestBody EtudiantRequest etudiantRequest) {
//        return etudiantService.updateEtudiant(id, etudiantRequest);
//    }
//

    @GetMapping(Endpoints.URL_ONE_CLIENT)
    public Optional<ClientDto> findOne(Long id) {
        return clientService.findOne(id);
    }

    @PostMapping(Endpoints.URL_CLIENT)
    public ClientDto save(ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @DeleteMapping(Endpoints.URL_ONE_CLIENT)
    public String delete(Long id) {
        return clientService.delete(id);
    }

}
