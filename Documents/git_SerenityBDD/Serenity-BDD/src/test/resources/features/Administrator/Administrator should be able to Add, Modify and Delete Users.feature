@regressiontest 
Feature:  Administrator should able to Add/Modify/Delete conference room users

@smoketest
Scenario: Administrator is able to add conference room users 
	Given User "Administrator" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	And Go to the User Information Page
	When User Information table header displays as "First Name" , "Last Name" , "Role" and "Email"
	And Add user information with firstName "FirstName1" , lastName "LastName1" and email "sample" 
	And Add user information with Eqiupment "sample" , Building "sample" , Room "sample" , Date "sample" and Time "sample"
	Then Verify new users has been added after submit
	And User log out from the App 
	
@pending
Scenario: Administrator is able to modify conference room users 
	Given User "Administrator" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	Then Administrator is able to modify exisitng users 
	
@pending @smoketest
Scenario: Adminsitrator is able to delete  conference room users 
	Given User "Administrator" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	Then Administrator is able to delete existing users 
	