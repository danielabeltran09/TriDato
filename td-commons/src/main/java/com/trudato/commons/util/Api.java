package com.trudato.commons.util;

import java.io.IOException;
import java.util.*;

import okhttp3.*;

public class Api {

    public Api() {
    }

    public static String post(String url, Map aux_headers, Map data){

        System.out.println("Llamando a post: "+url);
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "doc=C&LICIDENT=1144025634");
        Request request = new Request.Builder()
                .url("http://web.mintransporte.gov.co/Consultas/transito/Informe23122010.asp")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Cache-Control", "no-cache")
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            return e.getLocalizedMessage();
        }
    }
    public static String get(String url, Map aux_headers, Map data, int a){

        System.out.println("Llamando ad post: "+url);
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "doc=C&LICIDENT=1144025634");
        Request request = new Request.Builder()
                .url("http://web.mintransporte.gov.co/Consultas/transito/Informe23122010.asp")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Cache-Control", "no-cache")
                //.addHeader("Postman-Token", "3b50c41e-996f-5f0d-c17c-f5d9b8548092")
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            return e.getLocalizedMessage();
        }
    }



}
