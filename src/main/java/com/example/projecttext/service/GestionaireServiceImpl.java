package com.example.projecttext.service;

import com.example.projecttext.dto.GestionaireDto;
import com.example.projecttext.model.Gestionaire;
import com.example.projecttext.repository.GestionaireRepository;
import com.example.projecttext.service.mapper.GestionaireMapStruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Log4j2
public class GestionaireServiceImpl implements GestionaireService {
    private final GestionaireRepository gestionaireRepository;
    private final GestionaireMapStruct gestionaireMapStruct;
    private final PasswordEncoder passwordEncoder;

    public GestionaireServiceImpl(GestionaireRepository gestionaireRepository, GestionaireMapStruct gestionaireMapStruct, PasswordEncoder passwordEncoder) {
        this.gestionaireRepository = gestionaireRepository;
        this.gestionaireMapStruct = gestionaireMapStruct;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public GestionaireDto save(GestionaireDto gestionaireDto) {
        Gestionaire gestionaire = gestionaireMapStruct.toEntity(gestionaireDto);
        Gestionaire gestionaire1 = gestionaireRepository.save(gestionaire);
        log.debug("Request to save Gestionaire : {}", gestionaire1);
        return gestionaireMapStruct.toDto(gestionaire1);
    }

    @Override
    public Optional<GestionaireDto> update(GestionaireDto gestionaireDto) {
        log.debug("Request to partially update Client : {}", gestionaireDto);

        return gestionaireRepository
                .findById(gestionaireDto.getId())
                .map(existingClient -> {
                    gestionaireMapStruct.toEntity(gestionaireDto);
                    return existingClient;
                })
                .map(gestionaireRepository::save)
                .map(gestionaireMapStruct::toDto);
    }

    @Override
    public Page<GestionaireDto> findAll(Pageable pageable) {
        log.debug("Request to get All clients ");
        return gestionaireRepository.findAll(pageable).map(gestionaireMapStruct::toDto);
    }

    @Override
    public Optional<GestionaireDto> findOne(Long id) {
        log.debug("Request to get gestionaire : {}", id);
        return gestionaireRepository.findById(id).map(gestionaireMapStruct::toDto);
    }

    @Override
    public String delete(Long id) {
        log.debug("Request to get gestionaire : {}", id);
        gestionaireRepository.deleteById(id);
        return "gestionaire supprimer avec succes";
    }
}
