package com.example.demo.service;

import com.example.demo.model.Personne;
import com.example.demo.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    public Personne createPersonne(Personne personne){
        return personneRepository.save(personne);
    }

    public List<Personne> getAllPersonnes(){
        return personneRepository.findAll();
    }
}
