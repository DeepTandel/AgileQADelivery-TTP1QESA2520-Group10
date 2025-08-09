@Booking
Feature: Booking Functionalilites
	@Valid
	Scenario Outline: Verify with valid Data(full name, phone, email, trip type, car type, date, number of passenger, trip time)
	Given Navigate to Booking page
	When Enter All field valid data for full name, phone, email, trip type, car type, date, number of passenger, trip time "<NoOfData>"
	And Click Book Now button
	Then Verify the valid data
	Examples:
	|NoOfData|
	|1|
	|2|
	
	@Invalid
	Scenario Outline: Verify with Invalid Data(full name, phone, email, trip type, car type, date, number of passenger, trip time)
	Given Navigate to Booking page
	When Enter All field Invalid data for full name, phone, email, trip type, car type, date, number of passenger, trip time "<NoOfData>"
	And Click Book Now button
	Then Verify the InValid data
	Examples:
	|NoOfData|
	|1|
	|2|
	|3|
	|4|
	|5|
	|6|
	|7|
	|8|
	|9|
	|10|
	
	@BlankData
	Scenario:	
	Verify with no Data(full name, phone, email, trip type, car type, date, number of passenger, trip time)
	Given Navigate to Booking page
	When Click Book Now button with no data
	Then Verify with No data 
	
	
	