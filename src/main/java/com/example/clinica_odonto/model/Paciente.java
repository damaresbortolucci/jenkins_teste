package com.example.clinica_odonto.model;

import com.example.clinica_odonto.dto.PacienteDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paciente {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private Integer idade;
    private Endereco endereco;
    private Integer idEndereco;
    
    public Paciente(){}

    public Paciente(PacienteDTO pacienteDTO, Endereco endereco) {
        this.id = pacienteDTO.getId();
        this.nome = pacienteDTO.getNome();
        this.sobrenome = pacienteDTO.getSobrenome();
        this.endereco = endereco;
    }
}
