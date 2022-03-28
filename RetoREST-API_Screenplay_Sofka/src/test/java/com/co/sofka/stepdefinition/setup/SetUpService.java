package com.co.sofka.stepdefinition.setup;

import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.apache.log4j.PropertyConfigurator;

import static com.co.sofka.util.log4j.Log4jValues.LOG4J_PROPERTIES_DIRECTORY;
import static com.co.sofka.util.log4j.Log4jValues.USER_DIRECTORY;

public class SetUpService {

    private void log4jSetUp() {
        PropertyConfigurator.configure(USER_DIRECTORY.getValue() + LOG4J_PROPERTIES_DIRECTORY.getValue());
    }

    protected void configureActor(String actorName) {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActor(actorName);
    }

    protected void generalSetUp() {
        log4jSetUp();

    }

}
