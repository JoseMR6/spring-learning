package com.example.p02_hola_thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class Conrolador {
    
    @GetMapping("/")
    public String comienzo() {
        log.info("Ejecutando Controlador MVC");
        return "indice";
    }
    
}
