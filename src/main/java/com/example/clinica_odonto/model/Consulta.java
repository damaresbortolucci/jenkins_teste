package com.example.clinica_odonto.model;

import com.example.clinica_odonto.dto.ConsultaDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Consulta {
    private Integer id;
    private Paciente paciente;
    private Dentista dentista;
    private Date dataHora;

    public Consulta(){};

    public Consulta(ConsultaDTO consultaDTO, Paciente paciente, Dentista dentista) {
        this.id = consultaDTO.getId();
        this.paciente = paciente;
        this.dentista = dentista;
        this.dataHora = consultaDTO.getDataHora();
    }
}
