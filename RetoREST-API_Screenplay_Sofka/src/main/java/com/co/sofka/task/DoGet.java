package com.co.sofka.task;

import com.co.sofka.model.Requests;
import com.co.sofka.util.MakeJsonRequest;
import com.co.sofka.util.pokeapi.SetExecutionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class DoGet implements Task {
    private String basePath;
    private String resource;

    public DoGet(String basePath, String resource) {
        this.basePath = basePath;
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        MakeJsonRequest jsonRequest = new MakeJsonRequest();
        String[] responseCosnult = new String[3];

        try {
            SetExecutionVariables.setParametersPokeGet(basePath, resource);
            responseCosnult = jsonRequest.consumeRestServices("Get", Requests.getUserEndPoint(),
                    Requests.getRequestHeaders(), Requests.getBodyRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Requests.setResponse(responseCosnult);
    }

    public static DoGet doGetWithResource(String basePath, String resource) {
        return new DoGet(basePath, resource);
    }

}
