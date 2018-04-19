@regressiontest
Feature: Requestor should be presented  with a message if attempted to book two conference rooms at the same time (Detect scheduling conflicts) ,Requestor can book a conference room ,Requestor isnot allowed to book a conference room if the conference times exceeds more than 3 hours

@pending
Scenario: Requestor should be able to book a conference room , should be presented with building, room number and AV equipment available
	Given User "Requestor" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	When Requestor can select building, roomnumber and AV equipment to schedule conference room
	Then Requestor can book a conference room
	And Verify conference is scheduled for that room 
	And Verify the day is in format of "0000-0000 Conference TitleName"
	
@pending	
Scenario: Verify scheduling conflict is detection functionality
	Given User "Requestor" logs in to the application "http://odos-my-reservations-web-odos-dev.ose.hcitc-unisys.com"
	When Requestor  books two connference rooms at the same time 
	Then Application displays scheduling conflict message to the user.