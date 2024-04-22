package com.example.projecttext.service;

import com.example.projecttext.dto.LivreurDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LivreurService {
    LivreurDto save(LivreurDto livreurDto);

    Optional<LivreurDto> update(LivreurDto livreurDto, Long id);

    Page<LivreurDto> findAll(Pageable pageable);

    Optional<LivreurDto> findOne(Long id);

    String delete(Long id);
}
