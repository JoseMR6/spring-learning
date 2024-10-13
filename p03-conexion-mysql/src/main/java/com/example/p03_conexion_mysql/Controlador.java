package com.example.p03_conexion_mysql;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.p03_conexion_mysql.dao.IndividuoDao;
import com.example.p03_conexion_mysql.domain.Individuo;

@Controller
@Slf4j
public class Controlador {

    @Autowired
    private IndividuoDao individuoDao;
    
    @GetMapping("/")
    public String comienzo(Model model) {
        Iterable<Individuo> individuos = individuoDao.findAll();

        log.info("Ejecutando Controlador MVC");

        model.addAttribute("individuos", individuos);

        return "indice";
    }
    
}
