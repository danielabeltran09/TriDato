package com.trudato.commons.util;

import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;

public class ResponseTridato {

    public static String  ok(int code, String message, String info){

        Gson gson = new Gson();
        try {
            String data = "";
            if(!info.isEmpty())
                data = gson.toJson(info);
            Answer answer=new Answer(code,message,data);
            String r =  gson.toJson(answer);
            System.out.println(r);
            return r;
        } catch (Exception e) {
            new Exception("info no valida", e.getCause());
        }


        return "";
    }
}

class Answer{
    private int code;
    private String message;
    private String data;

    public Answer(int code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }



}
