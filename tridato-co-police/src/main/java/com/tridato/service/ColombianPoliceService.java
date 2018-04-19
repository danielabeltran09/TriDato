package com.tridato.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colombian-police")
public class ColombianPoliceService {

    @GetMapping("/health")
    public String health() {

        return "Colombian police is alive 3";
    }
}

