package com.example.projecttext.service;

import com.example.projecttext.dto.GestionaireDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GestionaireService {
    GestionaireDto save(GestionaireDto gestionaireDto);

    Optional<GestionaireDto> update(GestionaireDto gestionaireDto, Long id);

    Page<GestionaireDto> findAll(Pageable pageable);

    Optional<GestionaireDto> findOne(Long id);

    String delete(Long id);
}
