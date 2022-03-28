package com.co.sofka.question;

import com.co.sofka.model.Requests;
import com.google.gson.JsonParser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class RegisterUserRespons implements Question<Boolean> {
    private static final Logger LOGGER = LogManager.getLogger(RegisterUserRespons.class);
    private static final String CODE = "200";
    private static final String TOKEN = "QpwL5tke4Pnpja7X4";
    JsonParser parserCode = new JsonParser();


    @Subject("register response")
    @Override
    public Boolean answeredBy(Actor actor) {

        String[] responseCode = Requests.getResponse();

        boolean result = false;
        result = responseCode[0].equals(CODE) && Requests.getMessageResponseRegister().contains(TOKEN);

        if(result == true){
           String msg1 = "el escenario es exitoso";
           LOGGER.info(msg1);
       }

        return result;
    }

    public static RegisterUserRespons was() {
        return new RegisterUserRespons();
    }

}