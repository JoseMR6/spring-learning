package com.example.p04_consumidor_control.web;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.p04_consumidor_control.domain.Individuo;
import com.example.p04_consumidor_control.servicio.IndividuoServicio;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class Controlador {

    @Autowired
    private IndividuoServicio individuoServicio;
    
    @GetMapping("/")
    public String comienzo(Model model) {
        List<Individuo> individuos = individuoServicio.listaIndividuos();

        log.info("Ejecutando Controlador MVC");

        model.addAttribute("individuos", individuos);

        return "indice";
    }

    @GetMapping("/anexar")
    public String anexar(Individuo individuo){
        return "cambiar";
    }

    @PostMapping("/salvar")
    public String salvar(Individuo individuo) {
        individuoServicio.salvar(individuo);
        return "redirect:/";
    }

    @GetMapping("/cambiar/{id_individuo}")
    public String cambiar(Individuo individuo, Model model) {
        individuo = individuoServicio.localizarIndividuo(individuo);
        model.addAttribute("individuo", individuo);

        return "cambiar";
    }
    
    @GetMapping("/borrar/{id_individuo}")
    public String borrar(Individuo individuo) {
        individuoServicio.borrar(individuo);

        return "redirect:/";
    }
    
}