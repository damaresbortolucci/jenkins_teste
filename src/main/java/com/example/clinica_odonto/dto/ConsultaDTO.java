package com.example.clinica_odonto.dto;

import com.example.clinica_odonto.model.Consulta;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ConsultaDTO {
    private Integer id;
    private Integer idPaciente;
    private Integer idDentista;
    private Date dataHora;

    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.idPaciente = consulta.getPaciente().getId();
        this.idDentista = consulta.getDentista().getId();
        this.dataHora = consulta.getDataHora();
    }
}
