package com.example.clinica_odonto.service.impl;

import com.example.clinica_odonto.model.Consulta;
import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.service.OdontoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class ConsultaServiceImpl implements OdontoService<Consulta> {

    private static Map<Integer, Consulta> consultaMap = new HashMap<>();
    private static int idGlobal =1;




    @Override
    public Consulta salvar(Consulta consulta) {
        return null;
    }



    @Override
    public Consulta buscarPorId(Integer id) {
        Consulta consulta = new Consulta();
        try{
            consulta = consultaMap.get(id);
        }catch (Exception e){
            return null;
        }
        return consulta;
    }


    @Override
    public Map<Integer, Consulta> buscarTodos() {
        return null;
    }

    @Override
    public Consulta atualizar(Consulta consulta) {
        return null;
    }

    @Override
    public void deletar(Integer id) {

    }
}
