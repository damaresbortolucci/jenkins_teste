package com.example.clinica_odonto.repository;

public interface IRepository<T> {
    T salvar(T t);
    T buscarPorId(Integer id);
}
