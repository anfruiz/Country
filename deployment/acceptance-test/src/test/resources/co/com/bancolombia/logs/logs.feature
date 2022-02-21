Feature: API to get the countries with highest population density

  How an API owner
  Required consult the log
  To know the history of the requests

  Background:
    * url urlBase

  Scenario: GET logs
    Given url urlBase
    And path 'logs'
    When method get
    Then status 200
    And match each response[*] == {id:"#number", numberOfCountries:"#number"}

