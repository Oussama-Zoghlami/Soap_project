package com.springbootsoap.repository;

import com.springbootsoap.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    Etudiant findByEtudiantId(long etudiantId);
}
