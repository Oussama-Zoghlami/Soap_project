package com.springbootsoap.services;

import com.springbootsoap.model.Etudiant;

public interface EtudiantService {

    void addEtudiant (Etudiant etudiant);
    Etudiant getEtudiantById(long etudiantId);
    void updateEtudiant(Etudiant etudiant);
    void deleteEtudiant (long etudiantId);
}