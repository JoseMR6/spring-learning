package com.example.p02_hola_thymeleaf;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
//import java.util.ArrayList;
import java.util.Arrays;

import com.example.domain.Individuo;

@Controller
@Slf4j
public class Conrolador {
    @Value("${indice2.hola2}")
    private String hola2;
    
    @GetMapping("/")
    public String comienzo(Model model) {
        String hola = "Probando mensajes";

        Individuo individuo = new Individuo();
        individuo.setNombre("Pedro");
        individuo.setApellido("Rajoy");
        individuo.setCorreo("correo@correo.com");
        individuo.setEdad("24 años");
        individuo.setTelefono("12344556765");

        Individuo individuo2 = new Individuo();
        individuo2.setNombre("Antonio");
        individuo2.setApellido("Perez");
        individuo2.setCorreo("antonio@correo.com");
        individuo2.setEdad("35 años");
        individuo2.setTelefono("454735234");

        //List<Individuo> individuos = new ArrayList();
        //individuos.add(individuo);
        //individuos.add(individuo2);

        List<Individuo> individuos = Arrays.asList(individuo,individuo2);

        log.info("Ejecutando Controlador MVC");
        model.addAttribute("hola", hola);
        model.addAttribute("hola2", hola2);
        model.addAttribute("individuo", individuo);
        model.addAttribute("individuos", individuos);
        //return "indice1";
        //return "indice2";
        return "indice3";
    }
    
}
