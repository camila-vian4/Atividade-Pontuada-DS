package com.example.atividade_pontuada.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dev {
    @GetMapping("/dev")
    public String dev(){
        return "Desenvolvedora: Camila Viana Lopes 🫰🏼";
    }
}
