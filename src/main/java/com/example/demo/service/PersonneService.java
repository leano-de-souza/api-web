package com.example.demo.service;

import com.example.demo.model.Personne;
import com.example.demo.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    public Personne createPersonne(Personne personne){
        return personneRepository.save(personne);
    }

}
