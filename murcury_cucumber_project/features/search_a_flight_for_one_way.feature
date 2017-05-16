@regression
Feature: User can search a flight for one way trip

  In order to place an order
  As a customer
  I want to search flights for one way trip.

  @smoke
  Scenario: Verify user can register and login to the Mercury Application
    Given Navigate to Mercury website 
    And I can register using userid as "Mercury" and password as "password"
    # And I select country as "United States" from top toolbar panel
    # When I mouse hover on Flights and Deals option
    # And I click on Flight link from Deals panel
    # Then I will be able to see the new deals

  @regression
  Scenario: Verify user can login and search for Flights
    # Given Log me out
    Given I login to lufthansa website using userid as "John001" and password as "Smith001"
    And I select country as "United States" from top toolbar panel
    # When I mouse hover on Flights and Deals option
    And I click on Flight link from Deals panel  

  @regression
  Scenario: Verify user can log out
    Given Log me out


   
