package com.example.p04_consumidor_control.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.p04_consumidor_control.domain.Individuo;

public interface IndividuoDao extends CrudRepository<Individuo, Long>{
}
