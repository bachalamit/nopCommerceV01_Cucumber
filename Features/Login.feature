Feature: Login

@SanityTest
Scenario: Successful Login With Valid Credentials

Given User launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters the credentials email is "admin@yourstore.com" and password is "admin"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration" 
When User Click on Logout 
Then Page Title should be "Your store. Login"
And Close Browser

@RegressionTest
Scenario Outline: Login With Data Driven

Given User launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters the credentials email is "<email>" and password is "<password>"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration" 
When User Click on Logout 
Then Page Title should be "Your store. Login"
And Close Browser

Examples:
	| email | password |
	| admin@yourstore.com | admin |
	| admin@yourstore.com | admin123 |
