package com.co.sofka.question;

import com.co.sofka.model.Requests;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TheName implements Question<Boolean> {
    JsonParser parserCode = new JsonParser();
    private static final Logger LOGGER = LogManager.getLogger(TheName.class);
    private String name;
    public static final String SUCCESSFULRS = "200";

    public TheName(String name) {
        this.name = name;
    }

    @Subject("consult response")
    @Override
    public Boolean answeredBy(Actor actor) {

        String[] responseCode = Requests.getResponse();
        JsonObject jsonOjectCode = parserCode.parse(responseCode[2]).getAsJsonObject();
        JsonObject data = jsonOjectCode.get("forms").getAsJsonArray().get(0).getAsJsonObject();
        String pokemon = data.get("name").getAsString();
        Boolean result = false;
        if (SUCCESSFULRS.equals(responseCode[0])) {
            result = pokemon.equals(name);
            String msg1 = "el nombre del pokemon obtanido es: " + pokemon + " el nombre del pokemon esperado era: " + name;
            LOGGER.info(msg1);
        }
        return result;
    }
    public static TheName was(String name) {
        return new TheName(name);
    }
}



