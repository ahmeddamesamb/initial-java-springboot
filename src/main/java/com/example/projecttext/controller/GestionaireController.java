package com.example.projecttext.controller;

import com.example.projecttext.dto.GestionaireDto;
import com.example.projecttext.service.GestionaireService;
import com.example.projecttext.utlis.Endpoints;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(Endpoints.URL_APP)
@CrossOrigin(origins = "", allowedHeaders = "*")
public class GestionaireController {
    private final GestionaireService gestionaireService;

    public GestionaireController(GestionaireService gestionaireService) {
        this.gestionaireService = gestionaireService;
    }

    @GetMapping(Endpoints.URL_GESTIONAIRE)
    public Page<GestionaireDto> getAllGestionaire(Pageable pageable) {
        return gestionaireService.findAll(pageable);
    }

    @PutMapping(Endpoints.URL_ONE_GESTIONAIRE)
    public Optional<GestionaireDto> updateGestionaire(GestionaireDto gestionaireDto) {
        return gestionaireService.update(gestionaireDto);
    }


    @GetMapping(Endpoints.URL_ONE_GESTIONAIRE)
    public Optional<GestionaireDto> getGestionaire(Long id) {
        return gestionaireService.findOne(id);
    }

    @PostMapping(Endpoints.URL_GESTIONAIRE)
    public GestionaireDto createGestionaire(GestionaireDto gestionaireDto) {
        return gestionaireService.save(gestionaireDto);
    }

    @DeleteMapping(Endpoints.URL_ONE_GESTIONAIRE)
    public String deleteGestionaire(Long id) {
        return gestionaireService.delete(id);
    }
}
