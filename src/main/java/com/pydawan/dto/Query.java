package com.pydawan.dto;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.json.JSONObject;

/**
 * A class that provides methods to query an API.
 * @author David Birtles
 */
public class Query {
    private Query() {
    }

    /**
     * A static method that takes an URL as argument, fetch data and returns a JSON
     * object.
     * 
     * @throws URISyntaxException
     * @throws IOException
     * @throws MalformedURLException
     */
    public static String fetch(String url) throws IOException {
        return fetch(new URL(url));
    }

    public static String fetch(URL url) throws IOException {
        return fetch(url, Map.of());
    }

    public static String fetch(URL url, Map<String, String> headers) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        for (Entry<String, String> header : headers.entrySet()) {
            connection.setRequestProperty(header.getKey(), header.getValue());
        }
        return fetch(connection);
    }

    public static String fetch(HttpURLConnection connection) throws IOException {
        int code = connection.getResponseCode();

        if (code/100 != 2)
            throw new RuntimeException("Failed : HTTP error code : " + code + "\r\n" + connection.getURL() + "\r\n" + connection.getResponseMessage());

        try (Scanner scan = new Scanner(connection.getInputStream())) {
            scan.useDelimiter("\r\n");
            String jsonStr = scan.tokens().collect(Collectors.joining("\r\n"));
            return jsonStr;
        }
    }

}
