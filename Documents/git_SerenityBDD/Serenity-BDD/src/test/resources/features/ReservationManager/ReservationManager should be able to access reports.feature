@regressiontest
Feature: Reservation Manager shall be able to access to a report for occupancy and vacancy rate of each conference room which is exportable with data depicted as a histogram.
         
@smoketest @pending
   Scenario: Reservation Manager can create report of occupancy and vacancy rate of conference rooms
	Given User "Manager" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
    When Reservation Manager is able to create report of occupancy and vacancy rate
    Then Reservation Manager can export data and graphs
    Then Data exported should show occupancy and vacancy rate of the conference rooms
    
    
 
         