package com.example.projecttext.repository;

import com.example.projecttext.model.Gestionaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestionaireRepository extends JpaRepository<Gestionaire, Long> {
}
