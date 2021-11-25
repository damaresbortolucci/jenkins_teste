package com.example.clinica_odonto.dto;

import com.example.clinica_odonto.model.Dentista;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistaDTO {
    private Integer id;
    private Integer numMatricula;
    private String nome;
    private String sobrenome;

    public DentistaDTO(Dentista dentista) {
        this.id = dentista.getId();
        this.numMatricula = dentista.getMatricula();
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
    }
}
