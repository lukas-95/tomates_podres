package com.example.tomates_podres.repository;

import com.example.tomates_podres.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    public List<Avaliacao> findAllByNotaContainingIgnoreCase(
            @Param("nota") Float nota);
}
