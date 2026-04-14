package com.main.api.step;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;


public class ApiSteps {
    private WebDriver driver;

    @Given("llamar a la api {string}")
    public void llamar_a_la_api(String url) {
        
    }   

    @When("generar una peticion GET")
    public void generar_una_peticion_get() {
        
    }   

    @Then("el código de respuesta debe ser {string}")
    public void el_codigo_de_respuesta_debe_ser(String codigo) {
        
    }   

    @After
    public void cerrarNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}
