package com.example.projecttext.service;

import com.example.projecttext.dto.GestionaireDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GestionaireService {

    GestionaireDto save(GestionaireDto gestionaireDto) throws Exception;

    Optional<GestionaireDto> update(GestionaireDto gestionaireDto) throws Exception;

    Page<GestionaireDto> findAll(Pageable pageable) throws Exception;

    Optional<GestionaireDto> findOne(Long id) throws Exception;

    String delete(Long id) throws Exception;
}