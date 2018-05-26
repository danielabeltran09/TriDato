package com.tridato.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        //String as = TextReader.getImgText("tridato-co-police/src/captcha.jpg");
        //System.out.println(as);
        SpringApplication.run(Application.class, args);
        //SpringApplication.r
    }
}
