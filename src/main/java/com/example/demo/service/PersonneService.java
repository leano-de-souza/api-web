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
    // Ajout 04/26
    public Personne getPersonneById(Long id) {
    return personneRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Personne not found"));
    }

    public Personne updatePersonne(Long id, Personne personneDetails) {
        Personne personne = getPersonneById(id);

        personne.setNom(personneDetails.getNom());
        personne.setPrenom(personneDetails.getPrenom());

        return personneRepository.save(personne);
    }

    public void deletePersonne(Long id) {
        Personne personne = getPersonneById(id);
        personneRepository.delete(personne);
    }
}
