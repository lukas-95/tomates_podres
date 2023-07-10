package com.example.tomates_podres.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tb_avaliacoes")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Esse atributo é de preenchimento obrigatório")
    @Size(min = 1, max = 30, message = "Este atributo tem que ter no minimo 1 caracteres e no maximo 30 caracteres")
    private String usuario;

    @NotNull(message = "Esse atributo é de preenchimento obrigatário")
    @Size(min = 1, max = 10, message = "Este atributo tem que ter no minimo 1 caracteres e no maximo 10 caracteres")
    private Float nota;

    @ManyToOne
    @JsonIgnoreProperties("avaliacoes")
    private Filme filme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }
}
