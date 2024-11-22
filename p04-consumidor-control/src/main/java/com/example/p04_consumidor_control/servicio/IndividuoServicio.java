package com.example.p04_consumidor_control.servicio;

import java.util.List;

import com.example.p04_consumidor_control.domain.Individuo;

public interface IndividuoServicio {

    public List<Individuo> listaIndividuos();

    public void salvar(Individuo individuo);

    public void borrar(Individuo individuo);

    public Individuo localizarIndividuo(Individuo individuo);
    
}
