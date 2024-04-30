package com.example.projecttext.service;

import com.example.projecttext.dto.LivreurDto;
import com.example.projecttext.model.ERole;
import com.example.projecttext.model.Livreur;
import com.example.projecttext.repository.LivreurRepository;
import com.example.projecttext.service.mapper.LivreurMapStruct;
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
public class LivreurServiceImpl implements LivreurService {
    private final LivreurRepository livreurRepository;
    private final LivreurMapStruct livreurMapStruct;
    private final PasswordEncoder passwordEncoder;

    public LivreurServiceImpl(LivreurRepository livreurRepository, LivreurMapStruct livreurMapStruct, PasswordEncoder passwordEncoder) {
        this.livreurRepository = livreurRepository;
        this.livreurMapStruct = livreurMapStruct;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LivreurDto save(LivreurDto livreurDto) {
        livreurDto.setPassword(passwordEncoder.encode(livreurDto.getPassword()));
        livreurDto.setERole(ERole.LIVREUR);
        Livreur livreur = livreurMapStruct.toEntity(livreurDto);
        Livreur livreur1 = livreurRepository.save(livreur);
        log.debug("Request to save livreur : {}", livreur1);
        return livreurMapStruct.toDto(livreur1);
    }

    @Override
    public Optional<LivreurDto> update(LivreurDto livreurDto) {
        log.debug("Request to partially update livreur : {}", livreurDto);

        return livreurRepository
                .findById(livreurDto.getId())
                .map(existingClient -> {
                    livreurMapStruct.toEntity(livreurDto);
                    return existingClient;
                })
                .map(livreurRepository::save)
                .map(livreurMapStruct::toDto);
    }

    @Override
    public Page<LivreurDto> findAll(Pageable pageable) {
        log.debug("Request to get All livreur ");
        return livreurRepository.findAll(pageable).map(livreurMapStruct::toDto);
    }

    @Override
    public Optional<LivreurDto> findOne(Long id) {
        log.debug("Request to get livreur : {}", id);
        return livreurRepository.findById(id).map(livreurMapStruct::toDto);
    }

    @Override
    public String delete(Long id) {
        log.debug("Request to get livreur : {}", id);
        livreurRepository.deleteById(id);
        return "livreur supprimer avec succes";
    }
}
