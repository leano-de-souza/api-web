package com.example.demo.controller;

import com.example.demo.model.Personne;
import com.example.demo.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/personne")
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Personne> create(@RequestBody Personne personne, BindingResult result) {
        if (result.hasErrors())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Personne must have a name");
        personneService.createPersonne(personne);
        return new ResponseEntity<Personne>(personne, HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Personne>> getAllPersonnes() {
        List<Personne> personnes = personneService.getAllPersonnes();
        return new ResponseEntity<>(personnes, HttpStatus.OK);
    }
}
