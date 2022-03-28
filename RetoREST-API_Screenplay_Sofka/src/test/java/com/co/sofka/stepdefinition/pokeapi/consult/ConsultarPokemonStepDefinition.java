package com.co.sofka.stepdefinition.pokeapi.consult;

import com.co.sofka.question.TheId;
import com.co.sofka.question.TheName;
import com.co.sofka.stepdefinition.setup.SetUpService;

import com.co.sofka.task.DoGet;
import io.cucumber.java.Before;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.apache.log4j.Logger;

import static com.co.sofka.task.DoGet.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class ConsultarPokemonStepDefinition extends SetUpService {

    private final Logger LOGGER = Logger.getLogger(ConsultarPokemonStepDefinition.class);
    private final String ACTOR = "User";

    @Before
    public void initSetUp() {
        generalSetUp();
        configureActor(ACTOR);
    }

    @When("el usuario envia la peticion con el path {string} get con el recurso {string}")
    public void elUsuarioEnviaLaPeticionConElPathGetConElRecurso(String basePath, String id) {
        theActorInTheSpotlight().attemptsTo(doGetWithResource(basePath, id));
    }

    @Then("el sistema debera mostrarle el nombre del pokemon {string}")
    public void elSistemaDeberaMostrarleElNombreDelPokemon(String name) {
        theActorInTheSpotlight().should(seeThat(TheName.was(name)));
    }

    @When("el usuario envia la peticion get con el path {string} y el recurso del movimiento {string}")
    public void elUsuarioEnviaLaPeticionGetConElPathYElRecursoDelMovimiento(String basePath, String move) {
        theActorInTheSpotlight().attemptsTo(doGetWithResource(basePath, move));
    }

    @Then("el sistema debera mostrarle el id del movimiento {string}")
    public void elSistemaDeberaMostrarleElIdDelMovimiento(String movement) {
        theActorInTheSpotlight().should(seeThat(TheId.was(movement)));
    }

}
