package com.tridato.service;

import com.tridato.service.constants.StringConstants;
import com.trudato.commons.util.TextReader;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/colombian-police")
public class ColombianPoliceService {

    @Value("${trudato.co.police.url.index}")
    private String index;

    @Value("${trudato.co.police.url.captcha}")
    private String captcha;

    @Value("${trudato.co.police.url.antecedentes}")
    private String antecedentes;

    @GetMapping("/health")
    public String health() {

        return "Colombian police is alive 1";
    }

    @GetMapping("/query/{id}")
    public String query(@PathVariable("id") final String id) throws IOException {

        final Connection.Response loginForm = Jsoup.connect(index).execute();

        final HashMap<String, String> cookies = new HashMap<>();
        cookies.putAll(loginForm.cookies());

        final HashMap<String, String> formData = new HashMap<>();
        formData.put(StringConstants.FormParameters.JAVAX_FACES_PARTIAL_AJAX, StringConstants.FormValues.TRUE);
        formData.put(StringConstants.FormParameters.JAVAX_FACES_SOURCE, StringConstants.FormValues.CONTINUAR_BTN);
        formData.put(StringConstants.FormParameters.JAVAX_FACES_PARTIAL_EXECUTE, StringConstants.FormValues.ALL);
        formData.put(StringConstants.FormParameters.CONTINUAR_BTN, StringConstants.FormValues.CONTINUAR_BTN);
        formData.put(StringConstants.FormParameters.FORM, StringConstants.FormValues.FORM);
        formData.put(StringConstants.FormParameters.ACEPTA_OPTION, StringConstants.FormValues.TRUE);
        formData.put(StringConstants.FormParameters.JAVAX_FACES_VIEW_STATE, StringConstants.FormValues.VIEW_STATE_CONSTANT);

        Jsoup.connect(index)
                .cookies(cookies)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .data(formData)
                .method(Connection.Method.POST)
                .execute();

        // Llamamos al link de la imagen
        Connection.Response resultImageResponse = Jsoup.connect(captcha)
                .cookies(cookies)
                .method(Connection.Method.GET)
                .execute();

        ByteArrayInputStream captchaImage = new ByteArrayInputStream(resultImageResponse.bodyAsBytes());
        final String textInCaptcha = TextReader.getImgText(ImageIO.read(captchaImage)).trim();

        // Llamamos al fin la pagina de los antecendentes
        HashMap<String, String> formDataAntencedentes = new HashMap<>();
        formDataAntencedentes.put(StringConstants.FormParameters.FORM_ANTECEDENTES, StringConstants.FormValues.FORM_ANTECEDENTES);
        formDataAntencedentes.put(StringConstants.FormParameters.CEDULA_INPUT, id);
        formDataAntencedentes.put(StringConstants.FormParameters.CEDULA_TIPO, StringConstants.DocumentType.CC);
        formDataAntencedentes.put(StringConstants.FormParameters.TEXTCAPTCHA, textInCaptcha);
        formDataAntencedentes.put(StringConstants.FormParameters.J_IDT_20, StringUtils.EMPTY);
        formDataAntencedentes.put(StringConstants.FormParameters.JAVAX_FACES_VIEW_STATE, StringConstants.FormValues.VIEW_STATE_CONSTANT);

        Connection.Response antecedentesPage = Jsoup.connect(antecedentes)
                .cookies(cookies)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .data(formDataAntencedentes)
                .method(Connection.Method.POST)
                .execute();

        return antecedentesPage.body();
    }
}

