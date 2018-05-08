package com.tridato.service;


import com.tridato.service.model.PoliceStartSession;
import com.trudato.commons.util.TextReader;
import io.netty.handler.codec.http.HttpContent;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@EnableEurekaClient
@SpringBootApplication
public class Application {

//    public static void main(String[] args) throws IOException {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
//        map.add("javax.faces.partial.ajax", "true");
//        map.add("javax.faces.source", "continuarBtn");
//        map.add("javax.faces.partial.execute", "@all");
//        map.add("continuarBtn", "continuarBtn");
//        map.add("form", "form");
//        map.add("aceptaOption", "true");
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//
//        RestTemplate restTemplate = new RestTemplate();
//        PoliceStartSession session = restTemplate.postForObject("https://antecedentes.policia.gov.co:7005/WebJudicial/index.xhtml", request , PoliceStartSession.class);
//
//        map.add("javax.faces.ViewState", session.getChanges().getUpdate());
//        request = new HttpEntity<>(map, headers);
//        restTemplate.postForEntity("https://antecedentes.policia.gov.co:7005/WebJudicial/index.xhtml", request , String.class);
//
//        URL urlInput = new URL("https://antecedentes.policia.gov.co:7005/WebJudicial/captcha.jpg");
//        BufferedImage bufferedImage = ImageIO.read(urlInput);
//        final String text = TextReader.getImgText(bufferedImage);
//
//        restTemplate.postForObject("https://antecedentes.policia.gov.co:7005/WebJudicial/index.xhtml", request , String.class);
//
//        System.out.println();
////        String as = TextReader.getImgText("tridato-co-police/src/captcha.jpg");
////        System.out.println(as);
//        //SpringApplication.run(Application.class, args);
//    }

    public static void main(String[] args) throws IOException {

        HashMap<String, String> cookies = new HashMap<>();
        HashMap<String, String> formData = new HashMap<>();

        // Ejecutamos la primera vez para obtener la sesion
        Connection.Response loginForm = Jsoup.connect("https://antecedentes.policia.gov.co:7005/WebJudicial/index.xhtml").execute();

        cookies.putAll(loginForm.cookies());

        formData.put("javax.faces.partial.ajax", "true");
        formData.put("javax.faces.source", "continuarBtn");
        formData.put("javax.faces.partial.execute", "@all");
        formData.put("continuarBtn", "continuarBtn");
        formData.put("form", "form");
        formData.put("aceptaOption", "true");
        formData.put("javax.faces.ViewState", "H4sIAAAAAAAAAIVSvWsUQRR/uXNjcknkPCVduhC0cBc74RA/E7J4ieKpKBbx3e7zds7Zncns7GVjEbTRQgRB7QQtxCqdf4HYCQpiZyX21pZxZu+4DwnkwQ6z875+v/d+u3/AkamCox3soptpxt1VTKM1lM7hn58+z9/7XoayD3MBBhFttJiOMX2wAhUuMFzBQAvlw7SOFKWR4GEu94ydOw/WZremzFk13yENlYDCjOMNJkWm4NjdRtGPY9J2r7Y6FOj6i2+331bTk7wEkEubJI1pmNGU6wClDiLMNmEHykOf09lg4enBa2lwc6x/8FfeUXDK9svd+xhQ6gYiliKhRLs3/VuMtq4LoRevKSFJ6e0rtJ1C32oGi4IjQ6zLSRaPO6v/E4Gh5QbjJMdU++FgxEWkn2hqk6r9fvf+7+OnZ0ow4YPTRZ7ReMX1LG6RerL7emHm1a9ndjKW05wpPWmXtrQ/qaZGTatmHaSa2CV158vHsy/ffF0rQakB04EBlK5jTBpqxRY828prasWSdr0BldTkhEUNDfO9CCa8JimGnD3EFqd6D4aFcOLAudqLkdNe3wzXBjipxrYpv1SUz70i3UMpOQtQM5F4Zht2mE0b12sH+0prwiikr46LhIlBtCBU2w1ZhyVu3+FeGgY8en7hx4fu8mYBY8qMnIWGqK1/vE8qN2pZHGU1AssdhTWqA5s6a6Bcpi5xIWMzAwus0LyfyEyPSzf/B7JJ2CB3AwAA");

        // Ejecutamos la segunda vez para pasar la primera pantalla y llegar a los antecedentes
        Connection.Response homePage = Jsoup.connect("https://antecedentes.policia.gov.co:7005/WebJudicial/index.xhtml")
                .cookies(cookies)
                .header(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded")
                .data(formData)
                .method(Connection.Method.POST)
                .execute();

        // Llamamos al link de la imagen
        Connection.Response resultImageResponse = Jsoup.connect("https://antecedentes.policia.gov.co:7005/WebJudicial/captcha.jpg")
                .cookies(cookies)
                .method(Connection.Method.GET)
                .execute();

        ByteArrayInputStream captchaImage = new ByteArrayInputStream(resultImageResponse.bodyAsBytes());
        FileOutputStream out = (new FileOutputStream(new java.io.File("tessdata/captcha.jpg")));
        out.write(resultImageResponse.bodyAsBytes());  // resultImageResponse.body() is where the image's contents are.
        out.close();
        final String textInCaptcha = TextReader.getImgText(ImageIO.read(captchaImage)).trim();

        // Llamamos al fin la pagina de los antecendentes
        HashMap<String, String> formDataAntencedentes = new HashMap<>();
        formDataAntencedentes.put("formAntecedentes", "formAntecedentes");
        formDataAntencedentes.put("cedulaInput", "1020775867");
        formDataAntencedentes.put("cedulaTipo", "cc");
        formDataAntencedentes.put("textcaptcha", textInCaptcha);
        formDataAntencedentes.put("j_idt20", " ");
        formDataAntencedentes.put("javax.faces.ViewState", "H4sIAAAAAAAAAIVSvWsUQRR/uXNjcknkPCVduhC0cBc74RA/E7J4ieKpKBbx3e7zds7Zncns7GVjEbTRQgRB7QQtxCqdf4HYCQpiZyX21pZxZu+4DwnkwQ6z875+v/d+u3/AkamCox3soptpxt1VTKM1lM7hn58+z9/7XoayD3MBBhFttJiOMX2wAhUuMFzBQAvlw7SOFKWR4GEu94ydOw/WZremzFk13yENlYDCjOMNJkWm4NjdRtGPY9J2r7Y6FOj6i2+331bTk7wEkEubJI1pmNGU6wClDiLMNmEHykOf09lg4enBa2lwc6x/8FfeUXDK9svd+xhQ6gYiliKhRLs3/VuMtq4LoRevKSFJ6e0rtJ1C32oGi4IjQ6zLSRaPO6v/E4Gh5QbjJMdU++FgxEWkn2hqk6r9fvf+7+OnZ0ow4YPTRZ7ReMX1LG6RerL7emHm1a9ndjKW05wpPWmXtrQ/qaZGTatmHaSa2CV158vHsy/ffF0rQakB04EBlK5jTBpqxRY828prasWSdr0BldTkhEUNDfO9CCa8JimGnD3EFqd6D4aFcOLAudqLkdNe3wzXBjipxrYpv1SUz70i3UMpOQtQM5F4Zht2mE0b12sH+0prwiikr46LhIlBtCBU2w1ZhyVu3+FeGgY8en7hx4fu8mYBY8qMnIWGqK1/vE8qN2pZHGU1AssdhTWqA5s6a6Bcpi5xIWMzAwus0LyfyEyPSzf/B7JJ2CB3AwAA");

        Connection.Response antecedentesPage = Jsoup.connect("https://antecedentes.policia.gov.co:7005/WebJudicial/antecedentes.xhtml")
                .cookies(cookies)
                .header(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded")
                .data(formDataAntencedentes)
                .method(Connection.Method.POST)
                .execute();

        System.out.println(antecedentesPage.body());
        System.out.println(textInCaptcha);
        System.out.println();
    }
}
