@regression
Feature: User can search a flight for one way trip

  In order to place an order
  As a customer
  I want to search flights for one way trip.

  @smoke
  Scenario: Verify user can register and login to the Mercury Application
    Given Navigate to Mercury website 
    And I can register using userid as "Mercury" and password as "password"

  # @regression
  # Scenario: Verify user can login and search for Flights
