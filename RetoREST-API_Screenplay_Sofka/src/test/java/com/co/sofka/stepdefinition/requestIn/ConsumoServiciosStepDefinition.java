package com.co.sofka.stepdefinition.requestIn;

import com.co.sofka.question.RegisterUserRespons;
import com.co.sofka.question.TheDeleteResponse;
import com.co.sofka.task.DeleteUser;
import com.co.sofka.task.RegisterUser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsumoServiciosStepDefinition {


    @When("el usuario envia la peticion de registro")
    public void elUsuarioEnviaLaPeticionDeRegistro(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        theActorInTheSpotlight().attemptsTo(RegisterUser.inPage(rows.get(1).get(0), rows.get(1).get(1)));

    }

    @Then("entonces el debera ver el codigo de respuesta y el mensaje")
    public void entoncesElDeberaVerElCodigoDeRespuestaYElMensaje() {
        theActorInTheSpotlight().should(seeThat(RegisterUserRespons.was()));
    }


    //Delete

    @When("el  envia la peticion de eliminar el usuario {string}")
    public void elEnviaLaPeticionDeEliminarElUsuario(String user) {
        theActorInTheSpotlight().attemptsTo(DeleteUser.theUser(user));
    }

    @Then("el debera ver el codigo de respuesta")
    public void elDeberaVerElCodigoDeRespuesta() {
        theActorInTheSpotlight().should(seeThat(TheDeleteResponse.was()));
    }


}
