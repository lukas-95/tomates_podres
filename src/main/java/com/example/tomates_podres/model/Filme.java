package com.example.tomates_podres.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table (name = "tb_filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Esse atributo é de preenchimento obrigatório")
    @Size(min = 1, max = 50, message = "Este atributo tem que ter no minimo 1 caracteres e no maximo 50 caracteres")
    private String titulo;

    @NotBlank(message = "Esse atributo é de preenchimento obrigatório")
    @Size(min = 1, max = 20, message = "Este atributo tem que ter no minimo 1 caracteres e no maximo 20 caracteres")
    @Column(nullable = false)
    private String genero;

    @NotNull(message = "o atributo ANO é obrigatorio")
    private int ano;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "filme",cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("filme")
    private List<Avaliacao> avaliacao;


    public List<Avaliacao> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(List<Avaliacao> avaliacao) {
        this.avaliacao = avaliacao;
    }

    private Double notaMedia;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(Double notaMedia) {
        this.notaMedia = notaMedia;
    }
}
