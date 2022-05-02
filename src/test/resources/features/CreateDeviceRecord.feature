Feature: User can create device record as Administrator

  Background:
    Given Browser is opened
    Then Open app

  Scenario Outline: log in by administrator accround, add device with all required fields and check it is in the list
    Given User enters username "userTghjF4" and password "ji56rg4b68gt" to log in
    Then User adds device with name "<name>", os "<os>" and country code "<countryCode>"
    Examples:
      | name | os | countryCode|
      | myDevise | Android | CZ |