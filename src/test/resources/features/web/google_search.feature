#Feature example web
Feature: Busqueda en Google

  Rule: Buscar en Google

    @web
    Scenario: Buscar Cucumber en Google
      Given Abrir navegador "Google"
      When Buscar en el navegador "Cucumber"
      Then El título debe contener "Cucumber"
