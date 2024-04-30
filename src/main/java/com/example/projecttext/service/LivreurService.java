package com.example.projecttext.service;

import com.example.projecttext.dto.LivreurDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LivreurService {
    LivreurDto save(LivreurDto livreurDto) throws Exception;

    Optional<LivreurDto> update(LivreurDto livreurDto) throws Exception;

    Page<LivreurDto> findAll(Pageable pageable) throws Exception;

    Optional<LivreurDto> findOne(Long id) throws Exception;

    String delete(Long id) throws Exception;
}
