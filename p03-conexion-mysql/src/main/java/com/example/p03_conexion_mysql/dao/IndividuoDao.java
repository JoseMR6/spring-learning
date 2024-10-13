package com.example.p03_conexion_mysql.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.p03_conexion_mysql.domain.Individuo;

public interface IndividuoDao extends CrudRepository<Individuo, Long>{
}
