package com.weather.builder;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by M.Malyus on 2/22/2018.
 */
public class WeatherParserBuilder {
    final static String urlOfService = "http://www.eurometeo.ru/ukraina/lvyvska-oblast/lviv/export/xml/data";

    public static Document createDocumentConnection() throws IOException, ParserConfigurationException, SAXException {
        Document doc = null;
        URL url = new URL(urlOfService);
        URLConnection uc = url.openConnection();
        InputStream inputStream = uc.getInputStream();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
        doc = db.parse(inputStream);
        doc.getDocumentElement().normalize();

        return doc;
    }
}
