package com.example.tomates_podres.controller;

import com.example.tomates_podres.model.Filme;
import com.example.tomates_podres.repository.AvaliacaoRepository;
import com.example.tomates_podres.repository.FilmeReposiroty;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@CrossOrigin(origins = "*", allowedHeaders = "*" )
public class FilmeController {

    @Autowired
    private FilmeReposiroty filmeReposiroty;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @GetMapping
    public ResponseEntity <List<Filme>> getAll() {
        return ResponseEntity.ok(filmeReposiroty.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Filme> getById(@PathVariable Long id) {

        return filmeReposiroty.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @PostMapping
    public ResponseEntity<Filme> post(@Valid @RequestBody Filme filme) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeReposiroty.save(filme));
    }














}
