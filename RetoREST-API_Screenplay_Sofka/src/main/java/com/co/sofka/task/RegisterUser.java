package com.co.sofka.task;

import com.co.sofka.model.Requests;
import com.co.sofka.util.MakeJsonRequest;
import com.co.sofka.util.pokeapi.SetExecutionVariables;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.annotations.Subject;

import java.util.ArrayList;
import java.util.List;

public class RegisterUser implements Task {
    public static final String SUCCESSFULRS = "200";
    private String email;
    private String password;

    public RegisterUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Subject("Register User")
    @Override
    public <T extends Actor> void performAs(T actor) {
        MakeJsonRequest jrRegister = new MakeJsonRequest();
        JsonParser parserRegister = new JsonParser();
        String[] responseRegister = new String[3];
        List<String> registerUserRs = new ArrayList<String>();


        try {
            SetExecutionVariables.setParametersRegisterUser(email, password);
            responseRegister = jrRegister.consumeRestServices("Post", Requests.getUserEndPoint(),
                    Requests.getRequestHeaders(), Requests.getBodyRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (SUCCESSFULRS.equals(responseRegister[0])) {
            JsonObject jsonObjectregister = parserRegister.parse(responseRegister[2]).getAsJsonObject();
            registerUserRs.add(jsonObjectregister.get("token").getAsString());
            Requests.setMessageResponseRegister(registerUserRs);
            Requests.setResponse(responseRegister);
        }
    }

    public static RegisterUser inPage(String email,String password) {
        return new RegisterUser(email,password);
    }
}
