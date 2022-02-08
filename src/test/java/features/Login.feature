Feature: Login into Application

Scenario: Positive test validation login

Given Initialize the browser
And Navigate to "url" website
And Click on Login icon in homepage to land on sign in page
When User eneters "username" and "password" and logs in
Then Credentials are enetred successfully for "username"