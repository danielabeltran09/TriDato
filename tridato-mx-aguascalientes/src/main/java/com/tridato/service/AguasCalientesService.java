package com.tridato.service;

import com.google.gson.Gson;
import com.tridato.service.Response.ResponseAguasCalientes;
import com.trudato.commons.util.Api;
import com.trudato.commons.util.ResponseTridato;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.*;

@RestController
public class AguasCalientesService {

    @RequestMapping("/")
    public String get( ){
        System.out.println("AguasCalientesService get");
        int areaID= 1;
        int groupDataID = 1;
        String postDate="03/05/2018";
        try {

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS).build();
            HttpUrl.Builder urlBuilder = HttpUrl.parse("http://serviciosweb.poderjudicialags.gob.mx/Majat/Acuerdos/GetListaDeAcuerdos").newBuilder();
            urlBuilder.addQueryParameter("areaID", areaID+"");
            urlBuilder.addQueryParameter("grupoAreaMateriaID", groupDataID+"");
            urlBuilder.addQueryParameter("fechaPublicacion", postDate);
            urlBuilder.addQueryParameter("tipoListaID", "1");
            String url = urlBuilder.build().toString();


            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .addHeader("Cache-Control", "no-cache")
                    .addHeader("Postman-Token", "bddf353c-f925-d679-d5ed-3f34c318d590")
                    .build();


            try {
                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    Gson gson = new Gson();
                    ResponseAguasCalientes responseAguasCalientes = gson.fromJson(response.body().string(), ResponseAguasCalientes.class);
                    if(responseAguasCalientes.isSuccess()){
                        return ResponseTridato.ok(1, responseAguasCalientes.getMessage(), "");
                        //return "ok";
                    }else{
                        return ResponseTridato.ok(-1, responseAguasCalientes.getMessage(), "");
                    }
                }

            } catch (IOException e) {
                return ResponseTridato.ok(-2, e.getLocalizedMessage(), "");
            }
        } catch (Exception e) {
            return ResponseTridato.ok(-3, e.getLocalizedMessage(), "");
        }
    }
}
