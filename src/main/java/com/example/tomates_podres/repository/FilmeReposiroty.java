package com.example.tomates_podres.repository;

import com.example.tomates_podres.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmeReposiroty extends JpaRepository<Filme, Long> {

    public List <Filme> findAllByTituloContainingIgnoreCase(
            @Param("titulo") String titulo);
}
