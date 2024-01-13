/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo10.programacrypto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 *
 * @author Sebastian
 */
public class PARCING {
    public static Crypto parseApiResponse(String jsonResponse) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);

        // Accessing data array in the response
        JsonNode dataArray = rootNode.get("data");

        // Check if dataNode is present in the response
        if (dataArray != null && dataArray.size() > 0) {
            // Accessing the first cryptocurrency (in this case, Bitcoin)
            //PRUEBA
            for (int i = 0; i <=dataArray.size(); i++) {
                
            }
            //FIN PRUEBA
            JsonNode cryptoInfo = dataArray.get(0); // Assuming the first cryptocurrency in the list

            // Verify if cryptoInfo is not null before accessing its properties
            if (cryptoInfo != null) {
                // Accessing the value of the cryptocurrency
                Crypto cript=new Crypto();
                cript.setValue(cryptoInfo.get("quote").get("USD").get("price").asDouble());
                cript.setName(cryptoInfo.get("name").asText());
                cript.setMarket_cap(cryptoInfo.get("quote").get("USD").get("market_cap").asLong());
                return cript;
            } else {
                System.out.println("Cryptocurrency not found in the response.");
                return null;
            }
        } else {
            System.out.println("No cryptocurrency data found in the response.");
            return null;
        }
    }
    
}
