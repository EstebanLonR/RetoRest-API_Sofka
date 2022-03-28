package com.co.sofka.runner.requestIn;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/requestIn/consumo_servicios.feature",
        glue = "com.co.sofka.stepdefinition", 
        snippets = CucumberOptions.SnippetType.CAMELCASE)


public class ConsumoServicios {
}
