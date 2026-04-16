#Feature example api
Feature: realizar peticion a una REST API a Pokeapi

  Background:
    Given llamar a la api "https://pokeapi.co/api/v2/pokemon/"

  @API
  Scenario: generar una peticion GET la REST API
    When generar una peticion GET
    Then el codigo de respuesta debe ser "200"
