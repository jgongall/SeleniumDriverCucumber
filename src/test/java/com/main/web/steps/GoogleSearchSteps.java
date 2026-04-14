package com.main.web.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.main.web.selectors.Selectors;
import com.main.web.utils.Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps extends Utils {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = getDriver("chrome");
    } 

    @Given("Abrir navegador {string}")
    public void openBrowser(String navegador) {
        driver.get("https://" + navegador + ".com");
    }

    @When("Buscar en el navegador {string}")
    public void search(String texto) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.name(Selectors.SEARCH_INPUT)));
        searchInput.sendKeys(texto);
        searchInput.submit();
        wait.until(ExpectedConditions.titleContains(texto));
    }

    @Then("El título debe contener {string}")
    public void elTituloDebeContener(String texto) {
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(texto.toLowerCase()),
                "El título no contiene el texto esperado: " + texto);
    }

    @After
    public void endTest() {
        closeDriver(driver);
    }
}
