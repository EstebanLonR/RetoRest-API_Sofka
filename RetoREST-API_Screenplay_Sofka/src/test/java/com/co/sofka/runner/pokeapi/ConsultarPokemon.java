package com.co.sofka.runner.pokeapi;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/pokeapi/consultar_pokemon.feature",
        glue = "com.co.sofka.stepdefinition.pokeapi.consult",
        snippets = SnippetType.CAMELCASE)
public class ConsultarPokemon {
}
