package com.tridato.service;

import com.trudato.commons.util.Api;
import org.apache.tomcat.util.http.parser.MediaType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;

@RestController
public class ColombiaMinTransporteService {

    @RequestMapping("/")
    public String get() {

        try {



            //RestTemplate restTemplate = new RestTemplate();
            //restTemplate.getForObject("http://web.mintransporte.gov.co/Consultas/transito/Informe23122010.asp", String.class);
            String url = "http://web.mintransporte.gov.co/Consultas/transito/Informe23122010.asp";
            Map header = new HashMap<String, String>();
            header.put("Content-Type", "application/x-www-form-urlencoded");

            Map data = new HashMap<String, Object>();
            data.put("doc","C");
            data.put("LICIDENT","1144025634");

            //return "Consumido";
            String html = Api.post(url, header, data);
            Document doc = Jsoup.parse(html);
            Elements tables = doc.getElementsByTag("table");
            //Obtengo el nombre
            String name = tables.get(4).select("tr").first().select("td").first().select("font").get(1).text();
            String restricciones = tables.get(7).select("tbody").first().select("tr").first().select("td").first().select("font").get(0).text();
            String sanciones = tables.get(11).select("font").get(1).text();



            return name+ restricciones + sanciones;
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }

    }
}
