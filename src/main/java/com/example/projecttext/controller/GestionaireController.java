package com.example.projecttext.controller;

import com.example.projecttext.dto.GestionaireDto;
import com.example.projecttext.service.GestionaireService;
import com.example.projecttext.utlis.Endpoints;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(Endpoints.URL_APP)
@CrossOrigin(origins = "", allowedHeaders = "*")
@Log4j2
public class GestionaireController {

    private final GestionaireService gestionaireService;

    public GestionaireController(GestionaireService gestionaireService) {
        this.gestionaireService = gestionaireService;
    }

    @GetMapping(Endpoints.URL_GESTIONAIRE)
    public Page<GestionaireDto> getAllGestionaire(Pageable pageable) throws Exception {
        return gestionaireService.findAll(pageable);
    }

    @PutMapping(Endpoints.URL_ONE_GESTIONAIRE)
    public Optional<GestionaireDto> updateGestionaire(GestionaireDto gestionaireDto) throws Exception {
        return gestionaireService.update(gestionaireDto);
    }

    @GetMapping(Endpoints.URL_ONE_GESTIONAIRE)
    public Optional<GestionaireDto> getGestionaire(Long id) throws Exception {
        return gestionaireService.findOne(id);
    }

    @PostMapping(Endpoints.URL_GESTIONAIRE)
    public GestionaireDto createGestionaire(GestionaireDto gestionaireDto) throws Exception {
        return gestionaireService.save(gestionaireDto);
    }

    @DeleteMapping(Endpoints.URL_ONE_GESTIONAIRE)
    public String deleteGestionaire(Long id) throws Exception {
        gestionaireService.delete(id);
        return "Gestionaire supprimé avec succès";
    }
}