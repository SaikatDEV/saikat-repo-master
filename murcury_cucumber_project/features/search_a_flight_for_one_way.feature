@regression
Feature: User can search a flight for one way trip

  In order to place an order
  As a customer
  I want to search flights for one way trip.

  @smoke
  Scenario: Verify user can register and login to the Mercury Application
    Given Navigate to Mercury website 
    When User register using userid as "Mercury" and password as "password"
    Then User is on the Landing Page

  @regression
  Scenario: Verify user can search for Flights
    Given User is on the Landing Page
    When User click on Cruises link
    Then User is on the Cruise Page

  @regression
  Scenario: Verify user can search for Flights
    Given User is on the Landing Page
    When User click on Cruises link
    Then User is on the Cruise Page

  @regression
  Scenario: Verify user can search for Flights
    Given User is on the Landing Page
    When User click on Cruises link
    Then User is on the Cruise Page

  @regression
  Scenario: Verify user can search for Flights
    Given User is on the Landing Page
    When User click on Cruises link
    Then User is on the Cruise Page

  @regression
  Scenario: Verify user can search for Flights
    Given User is on the Landing Page
    When User click on Cruises link
    Then User is on the Cruise Page