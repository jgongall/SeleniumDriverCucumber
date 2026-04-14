#Feature example api
Feature: realizar peticion a una api

  Scenario: generar una peticion a la api
    Given llamar a la api "https://jsonplaceholder.typicode.com/posts"
    When generar una peticion GET
    Then el código de respuesta debe ser "200"
