@sample
Feature: Sample Feature

#@sample @sample @sample
#  Scenario Outline:  User should not have ability to Edit Elert Email Lists 
#    Given Login to Pride using test user as "<Users>" 
#    When Select Firms code "<FirmsCode>"
#  	And Submit Firms Code
#  	And Select DDL list "Action Menu" from menu bar
#  	Then Select "Manage/View Alert Group Email (AGE) List" from Action Menu drop down
#  	And Elert Email page is loaded
#  	And Functionality "Edit" should not be available in Elert Email Page
#  	Examples:
#    | Users 		| FirmsCode 						|
#    | FIELDOFFICER 	| New York, GCT-NY (Howland Hook) 	|
#    | HQ			| Detroit, Fort Street Cargo		|
#    | LSS			| Detroit, Fort Street Cargo		|
#    | OFFICER		| Detroit, Ambassador Bridge		|
#    | READONLY		| New York, GCT-NY (Howland Hook)	|

@sample
  Scenario Outline:  Sample test Get all Student from Student App 
    Given Navigate to the App "<Url>"
    And Verify the status code is "<StatusCode>"
    Examples:
    |	Url								|	StatusCode		|
    |	http://localhost:8085/student/	|	200				|
#    |	http://localhost:8085/student	|	405				|


    
    