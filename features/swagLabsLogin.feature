Feature: to verify the login with the multiple data in swag labs login page

@Login
Scenario Outline: to verify the login page of swag labs
Given launch swag labs application
When login to the application with valid or invalid "<username>" and "<password>" 
Then validate the error message "error1" or "error2" or "error3"


Examples:

|username|password|
|abc@gmail.com||
||788787|
|||                        
|abc@gmail.com|123456|                     
|standard_user|7697897|
|ria@gmail.com|secret_sauce|
|standard_user|secret_sauce|

@Checkout
Scenario Outline: to order an item
Given I want to order an item 
When validate an information with entering "<firstname>" and "<lastname>" and "<zipcode>" 
And validate the error message for invalid information "error1" or "error2" or "error3" 
Then order an item with valid information

Examples:
|firstname|lastname|zipcode|
||||
||Singh|560001|
|Ria||560001|
|Ria|Singh||

@HomePage
Scenario: home page validation
Given I am in home page
When validate filters
Then validate menu options 
 

















