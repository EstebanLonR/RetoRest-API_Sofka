package com.co.sofka.question;

import com.co.sofka.model.Requests;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TheId implements Question<Boolean> {
    private static final Logger LOGGER = LogManager.getLogger(TheId.class);
    JsonParser parserCode = new JsonParser();
    private String id;
    public static final String SUCCESSFULRS = "200";

    public TheId(String id) {
        this.id = id;
    }

    @Subject("consult response")
    @Override
    public Boolean answeredBy(Actor actor) {

        String[] responseCode = Requests.getResponse();
        JsonObject jsonOjectCode = parserCode.parse(responseCode[2]).getAsJsonObject();
        String value = jsonOjectCode.get("id").getAsString();
        Boolean result = false;
        if (SUCCESSFULRS.equals(responseCode[0])) {
           result = value.equals(id);
            String msg1 = "el id obtenido es " + value + " el id esperado es: " + id;
            LOGGER.info(msg1);
        }
        return result;
    }

    public static TheId was(String id) {
        return new TheId(id);
    }
}
