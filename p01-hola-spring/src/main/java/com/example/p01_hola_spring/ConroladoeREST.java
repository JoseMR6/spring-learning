package com.example.p01_hola_spring;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Slf4j
public class ConroladoeREST {
    
    @GetMapping("/")
    public String comienzo() {
        log.info("Ejecutando Controlador REST");
        log.debug("INFO DEBUG MODE");
        return "Hola Mundo en Spring";
    }
    
}
