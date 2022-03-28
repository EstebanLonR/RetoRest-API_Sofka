package com.co.sofka.util;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class MakeJsonRequest {
    private static final Logger LOGGER = LogManager.getLogger(MakeJsonRequest.class);

    public String[] consumeRestServices(String requestType, String requestEndpoint, Map<String, String> headers,
                                        String bodyRequest) throws Exception {
        String[] responseAux = new String[3];
        HttpResponse<JsonNode> response = null;
        String msg1 = "Consumption of a " + requestType + " request";
        LOGGER.info(msg1);
        try {
            if ("Post".equalsIgnoreCase(requestType)) {
                response = Unirest.post(requestEndpoint)
                        .headers(headers)
                        .body(bodyRequest).asJson();
            } else if ("Get".equalsIgnoreCase(requestType)) {
                response = Unirest.get(requestEndpoint)
                        .headers(headers).asJson();
            } else if ("Delete".equalsIgnoreCase(requestType)) {
                response = Unirest.delete(requestEndpoint)
                        .headers(headers).asJson();
            } else {
                LOGGER.info("Error trying to consume Rest Services: unsupported type of request");
            }
            if (requestType.equals("Delete")) {
                assert response.getStatus() != 0;
                responseAux[0] = String.valueOf(response.getStatus());
                responseAux[1] = "";
                responseAux[2] = "";
            } else {
                assert response != null;
                responseAux[0] = String.valueOf(response.getStatus());
                responseAux[1] = response.getStatusText();
                responseAux[2] = IOUtils.toString(response.getRawBody(), StandardCharsets.UTF_8);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        String msg2 = "El servicio respondio un código " + response.getStatus() + " " + response.getStatusText();
        LOGGER.info(msg2);
        String msg3 = "El body fue " + response.getBody();
        LOGGER.info(msg3);
        return responseAux;
    }
}