package com.example.projecttext.controller;

import com.example.projecttext.dto.LivreurDto;
import com.example.projecttext.service.LivreurService;
import com.example.projecttext.utlis.Endpoints;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(Endpoints.URL_APP)
@CrossOrigin(origins = "", allowedHeaders = "*")

public class LivreurController {
    private final LivreurService livreurService;


    public LivreurController(LivreurService livreurService) {
        this.livreurService = livreurService;
    }

    @GetMapping(Endpoints.URL_LIVREUR)
    public Page<LivreurDto> getAllLivreur(Pageable pageable) {
        return livreurService.findAll(pageable);
    }

    @PutMapping(Endpoints.URL_ONE_LIVREUR)
    public Optional<LivreurDto> updateLivreur(LivreurDto livreurDto) {
        return livreurService.update(livreurDto);
    }


    @GetMapping(Endpoints.URL_ONE_LIVREUR)
    public Optional<LivreurDto> getLivreur(Long id) {
        return livreurService.findOne(id);
    }

    @PostMapping(Endpoints.URL_LIVREUR)
    public LivreurDto createLivreur(LivreurDto livreurDto) {
        return livreurService.save(livreurDto);
    }

    @DeleteMapping(Endpoints.URL_ONE_LIVREUR)
    public String deleteLivreur(Long id) {
        return livreurService.delete(id);
    }
}
