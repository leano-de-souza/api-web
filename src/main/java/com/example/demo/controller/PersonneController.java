package com.example.demo.controller;

import com.example.demo.model.Personne;
import com.example.demo.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

// 04/26
@RestController
@RequestMapping("/personne")
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    // CREATE
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Personne> create(@RequestBody Personne personne) {
        Personne saved = personneService.createPersonne(personne);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping("/all")
    public ResponseEntity<List<Personne>> getAllPersonnes() {
        return ResponseEntity.ok(personneService.getAllPersonnes());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Personne> getById(@PathVariable Long id) {
        return ResponseEntity.ok(personneService.getPersonneById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Personne> update(@PathVariable Long id, @RequestBody Personne personne) {
        return ResponseEntity.ok(personneService.updatePersonne(id, personne));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personneService.deletePersonne(id);
        return ResponseEntity.noContent().build();
    }
}


