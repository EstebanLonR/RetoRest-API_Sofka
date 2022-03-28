package com.co.sofka.util.pokeapi;

import com.co.sofka.model.Requests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class SetExecutionVariables {

    private static final String BASE_URI = "https://pokeapi.co/api/v2";
    private static final String BASE_ENDPOINT = "https://reqres.in/api/";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APP_JSON = "application/json";
    private static final String PATH = "src/main/resources/jsonrequest";
    private static final String EMAIL = "{email}";
    private static final String PASSWORD = "{password}";

    public static String getBodyRQFromFile(String fileroute) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileroute)));
    }

    public static void setParametersPokeGet(String basePath,String resource ) {
        Requests.setUserEndPoint(BASE_URI + basePath + resource);
    }


    public static void setParametersRegisterUser(String email, String password) throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE, APP_JSON);
        Requests.setRequestHeaders(headers);
        Requests.setUserEndPoint(BASE_ENDPOINT + "register");
        Requests.setBodyRequest(getBodyRQFromFile(PATH + "/register.json")
                .replace(EMAIL, email)
                .replace(PASSWORD, password));

    }

    public static void setParametersDelete(String user) throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE, APP_JSON);
        Requests.setRequestHeaders(headers);
        Requests.setUserEndPoint(BASE_ENDPOINT + "users/" + user);
    }

}
