package com.example.p04_consumidor_control.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.p04_consumidor_control.dao.IndividuoDao;
import com.example.p04_consumidor_control.domain.Individuo;

@Service
public class IndividuoServicioImp implements IndividuoServicio {

    @Autowired
    private IndividuoDao individuoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Individuo> listaIndividuos() {
        return (List<Individuo>) individuoDao.findAll();
    }

    @Override
    @Transactional
    public void salvar(Individuo individuo) {
        individuoDao.save(individuo);
    }

    @Override
    @Transactional
    public void borrar(Individuo individuo) {
        individuoDao.delete(individuo);
    }

    @Override
    @Transactional(readOnly = true)
    public Individuo localizarIndividuo(Individuo individuo) {
        return individuoDao.findById(individuo.getId_individuo()).orElse(null);
    }

}
