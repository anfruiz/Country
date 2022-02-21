Feature: API to get the countries with highest population density

  How a person
  Required the countries with highest population density
  To know the statistics

  Background:
    * url urlBase
    * def countrySchema = read('./schemas/CountrySchema.json')
    * def countriesJson = read('./schemas/FiveCountriesResponse.json')

  Scenario: Validate response schema
    Given path 'countries/2'
    When method get
    Then status 200
    And match each response[*] == countrySchema

  Scenario: Validate response schema
    Given path 'countries/5'
    When method get
    Then status 200
    And match response == countriesJson