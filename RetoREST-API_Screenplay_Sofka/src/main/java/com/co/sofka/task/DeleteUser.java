package com.co.sofka.task;

import com.co.sofka.model.Requests;
import com.co.sofka.util.MakeJsonRequest;
import com.co.sofka.util.pokeapi.SetExecutionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.annotations.Subject;

public class DeleteUser implements Task {

    private final String userid;

    public DeleteUser(String userid) {

        this.userid = userid;
    }

    public static DeleteUser theUser(String user) {
        return new DeleteUser(user);
    }

    @Subject("Delete")
    @Override
    public <T extends Actor> void performAs(T actor) {
        MakeJsonRequest jrDelete = new MakeJsonRequest();
        String[] responseDelete = new String[3];

        try {
            SetExecutionVariables.setParametersDelete(userid);
            responseDelete = jrDelete.consumeRestServices("Delete", Requests.getUserEndPoint(),
                    Requests.getRequestHeaders(), Requests.getBodyRequest());

        } catch (Exception e) {
            e.printStackTrace();
        }
        Requests.setResponse(responseDelete);
    }
}
