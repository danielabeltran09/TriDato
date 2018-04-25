package com.tridato.service;


import com.trudato.commons.util.TextReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@EnableEurekaClient
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        String as = TextReader.getImgText("tridato-co-police/src/captcha.jpg");
        System.out.println(as);
        //SpringApplication.run(Application.class, args);
    }
}
