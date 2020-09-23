@Login
Feature: Login Feature
#This feature includes scenario that would validat eteh following features.
#1. Login as Admin
#2. Login as Linda.anderson
#3. Login with invalid test data

#@Positive
#Scenario: 1. Login as Admin
#Given I am able to navigate onto the login page
#When I enter the username as "Admin"
#And I Enter teh password is "admin123"
#And I click on submit button
#Then I should see the username as "Welcome Linda"
#Then Do logout
#
#@Positive
#Scenario: 2. Login as Linda.anderson
#Given I am able to navigate onto the login page
#When I enter the username as "Linda.anderson"
#And I Enter teh password is "Linda.anderson"
#And I click on submit button
#Then I should see the username as "Welcome Test"
#Then Do logout

Background:
Given I am able to navigate onto the login page

Scenario Outline: Login with different user
When I enter the username as "<userNm>"
And I Enter teh password is "<pwd>"
And I click on submit button
Then I should see the username as "<mssg>"
Then Do logout
Examples:

|userNm					|pwd						|mssg					|
|Admin					|admin123				|Welcome Linda	|
|Linda.anderson	|Linda.anderson	|Welcome Linda	|




@Negative
Scenario: 3. Login with invalid test data
Given I am able to navigate onto the login page
When I enter the username as "dummyUserNm"
And I Enter teh password is "dummyPwd"
And I click on submit button
Then I should see the error message "Invalid credentials"