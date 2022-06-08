Feature: Customers

	Background: Below are the common steps for each scenario
Given User launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters the credentials email is "admin@yourstore.com" and password is "admin"
And Click on Login
Then User can view Dashboard

@SanityTest
Scenario: Add a new customer
When Customer click on Customers menu
And User click on customer menu item
And Click on Add new button
Then Customer can view add new customer page
When User enter customer info
And Click on save button
Then User can view confirmation message "The new customer has been added successfully."
And Close Browser


@RegressionTest
Scenario: Search Customer by EmailID

When Customer click on Customers menu
And User click on customer menu item
And Enter Customer Email
When Click on Search button
Then User should found email in the search table
And Close Browser

@RegressionTest
Scenario: Search Customer by Name

When Customer click on Customers menu
And User click on customer menu item
And Enter Customer Fist Name
And Enter Customer Last Name
When Click on Search button
Then User should found name in the search table
And Close Browser



	
