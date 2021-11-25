package com.example.clinica_odonto.service.impl;

import com.example.clinica_odonto.model.Dentista;
import com.example.clinica_odonto.repository.impl.DentistaRepositoryImpl;
import com.example.clinica_odonto.service.OdontoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DentistaServiceImpl implements OdontoService<Dentista> {
    private static Map<Integer, Dentista> dentistaMap = new HashMap<>();
    private static int idGlobal =1;

    private DentistaRepositoryImpl dentistaRepository;

    public DentistaServiceImpl() {
        this.dentistaRepository = new DentistaRepositoryImpl();
    }


    @Override
    public Dentista salvar(Dentista dentista) {
        return dentistaRepository.salvar(dentista);
    }

    @Override
    public Dentista buscarPorId(Integer id) {
        return dentistaRepository.buscarPorId(id);
    }


    //sem repository
    @Override
    public Map<Integer, Dentista> buscarTodos() {
        return dentistaMap;
    }

    @Override
    public Dentista atualizar(Dentista dentista) {
        dentistaMap.put(dentista.getId(), dentista);
        return dentista;
    }

    @Override
    public void deletar(Integer id) {
        dentistaMap.remove(id);
    }
}
