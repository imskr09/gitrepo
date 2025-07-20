Feature: Login to Tutorial Ninja
  I want to use this login feature file to successful login

  Scenario: Login with valide credentional
    Given Open the Browser
    And Navigate to Login page
    When user enters username as "luv2@gmail.com" and password as "Luv001"
    And user clicks on Login button
    Then verify user is able to successfully login
    
 Scenario: Login with invalide credentional
    Given Open the Browser
    And Navigate to Login page
    When user enters username as "luv122@gmail.com" and password as "Luv001"
    And user clicks on Login button
    Then verify user is able to successfully login
    
    