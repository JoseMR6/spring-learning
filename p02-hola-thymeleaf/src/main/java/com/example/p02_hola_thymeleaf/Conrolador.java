package com.example.p02_hola_thymeleaf;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

        log.info("Ejecutando Controlador MVC");
        model.addAttribute("hola", hola);
        model.addAttribute("hola2", hola2);
        model.addAttribute("individuo", individuo);
        //return "indice1";
        return "indice2";
    }
    
}
