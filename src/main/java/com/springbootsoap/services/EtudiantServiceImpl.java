package com.springbootsoap.services;

import com.springbootsoap.model.Etudiant;
import com.springbootsoap.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;


    @Override
    public void addEtudiant(Etudiant etudiant) {
        etudiantRepository.save(etudiant);

    }

    @Override
    public Etudiant getEtudiantById(long etudiantId) {
        Etudiant obj =etudiantRepository.findByEtudiantId(etudiantId);
        return obj;
    }

    @Override
    public void updateEtudiant(Etudiant etudiant) {
        etudiantRepository.save(etudiant);

    }

    @Override
    public void deleteEtudiant(long etudiantId) {
        etudiantRepository.deleteById(etudiantId);

    }
}