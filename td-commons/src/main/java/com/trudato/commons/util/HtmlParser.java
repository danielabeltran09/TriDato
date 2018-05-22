package com.trudato.commons.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlParser {

    public static void parseString(String html){
        Document doc = Jsoup.parse(html);

    }
}
