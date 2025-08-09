@Services
Feature: Cab Services 

	Scenario Outline: Verify Mini Car Service link
	Given Navigate to Service page
	When Click on "<Type>" car service link
	Then Verify image and details of "<Type>" is "<Details>"
	Examples:
	|Type|Details|
	|mini|Mini Cars|
	|micro|Micro Cars|
	|sUV|Suv Cars|
	|sedan|Sedan Cars|
	
	
	