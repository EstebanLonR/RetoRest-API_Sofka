package com.co.sofka.question;

import com.co.sofka.model.Requests;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TheDeleteResponse implements Question<Boolean> {
    private static final Logger LOGGER = LogManager.getLogger(TheDeleteResponse.class);
    private static final String CODE = "204";

    @Subject("delete response")
    @Override
    public Boolean answeredBy(Actor actor) {
        String[] responseCode = Requests.getResponse();
        boolean result = false;

        result = responseCode[0].equals(CODE);

        if(result == true){
            String msg1 = "el escenario es exitoso";
            LOGGER.info(msg1);
        }

        return result;
    }

    public static TheDeleteResponse was() {
        return new TheDeleteResponse();
    }
}

