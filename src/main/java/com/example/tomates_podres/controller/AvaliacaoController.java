package com.example.tomates_podres.controller;


import com.example.tomates_podres.model.Avaliacao;
import com.example.tomates_podres.repository.AvaliacaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes")
@CrossOrigin(origins = "*", allowedHeaders = "*" )
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @PostMapping
    public ResponseEntity<Avaliacao> post(@Valid @RequestBody Avaliacao avaliacao){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(avaliacaoRepository.save(avaliacao));
    }

}
