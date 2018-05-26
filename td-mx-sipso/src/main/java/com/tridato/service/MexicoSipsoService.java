package com.tridato.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/mexican-sipso")
public class MexicoSipsoService {

    @Value("${trudato.mx.sipso.url.index}")
    private String index;

    @GetMapping("/health")
    public ResponseEntity health() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/query/{curp}")
    public String query(@PathVariable("curp") final String curp) throws IOException {

        final Connection.Response loginForm = Jsoup.connect(String.format(index, curp)).execute();
    }
}
