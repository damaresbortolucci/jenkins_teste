package com.example.clinica_odonto.repository.impl;


import com.example.clinica_odonto.dto.ConsultaDTO;
import com.example.clinica_odonto.model.Consulta;
import com.example.clinica_odonto.model.Dentista;
import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ConsultaRepositoryImpl implements IRepository<Consulta> {
    private static Map<Integer, ConsultaDTO> consultaDTOMap = new HashMap<>();
    private static Integer idGlobal = 1;

    private DentistaRepositoryImpl dentistaRepository;
    private PacienteRepositoryImpl pacienteRepository;

    public ConsultaRepositoryImpl(){
        this.dentistaRepository = new DentistaRepositoryImpl();
        this.pacienteRepository = new PacienteRepositoryImpl();
    }

    @Override
    public Consulta salvar(Consulta consulta) {
        //buscando dados no BD e criando obj paciente
        Paciente paciente = pacienteRepository.buscarPorId(consulta.getPaciente().getId());
        if(paciente == null)
            return null;
        //buscando dados no BD e criando obj dentista
        Dentista dentista = dentistaRepository.buscarPorId(consulta.getDentista().getId());
        if(dentista == null)
            return null;

        //populando meu objeto consulta que dps será usada como parametro para criar o DTO
        consulta.setId(idGlobal);
        consulta.setPaciente(paciente);
        consulta.setDentista(dentista);

        //jogando o obj dentista para ser convertido em DTO (dto vai se usado pelo BD)
        ConsultaDTO consultaDTO = new ConsultaDTO(consulta);
        //salvando a consulta na tabela MAP
        consultaDTOMap.put(idGlobal, consultaDTO);
        idGlobal++;
        return consulta;
    }


    @Override
    public Consulta buscarPorId(Integer id) {
        return null;
    }
}
