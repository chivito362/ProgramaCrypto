package com.equipo10.programacrypto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ProgramaCrypto {

    private static String apiKey = "8b139d35-6338-4602-875b-7941217d2995";

    public static void main(String[] args) {
        String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("start", "1"));
        parameters.add(new BasicNameValuePair("limit", "5000"));
        parameters.add(new BasicNameValuePair("convert", "USD"));

        try {
            String result = MAKEAPICALL.makeAPICall(uri, parameters,apiKey);
            // Parse JSON response
            Crypto parseApiResponse = PARCING.parseApiResponse(result);
            System.out.println(parseApiResponse);
        } catch (IOException | URISyntaxException e) {
            System.out.println("Error: " + e.toString());
        }
    }

    
}