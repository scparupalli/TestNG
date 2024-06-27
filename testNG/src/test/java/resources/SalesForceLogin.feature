Feature: Salesforce Login Scenarios

  Scenario: Verify Salesforce application page is displayed and Login Error Message
    Given the url "https://tekarch-7b-dev-ed.develop.my.salesforce.com"
    When i land in "LoginPage"
    Then I should see the Salesforce application page
    When i enter the username as "srujana@p.sandbox"
    And I clear the password field
    And I click on the Login to Salesforce button
    Then I should see the error message "Please enter your password."

  Scenario: Successful login
    Given the url "https://tekarch-7b-dev-ed.develop.my.salesforce.com"
    When i enter the username as "srujana@p.sandbox"
    And i enter the password as "LetsLearn1!"
    And i click on the Login to Salesforce button
    Then i should see the Salesforce home page

  Scenario: Remember username after logout
    Given the url "https://tekarch-7b-dev-ed.develop.my.salesforce.com"
    When i enter the username as "srujana@p.sandbox"
    And i enter the password as "LetsLearn1!"
    And i select the remember username checkbox
    And i click on the Login to Salesforce button
    Then i should see the Salesforce home page
    When i click on the user menu dropdown
    And i select the logout link
    Then i should see the Salesforce login page
    And the username field should be populated with "validUsername"
    And the remember username checkbox should be checked

  Scenario: Forgot password
    Given the url "https://tekarch-7b-dev-ed.develop.my.salesforce.com"
    When i click on the Forgot Password link
    Then i should see the Salesforce forgot password page
    When i enter "validUsername" in the forgot password username field
    And i click on the Continue button
    Then i should see the password reset message
    And an email should be sent to the email associated with "srujana@p.sandbox"

  Scenario: Invalid login
    Given the url "https://tekarch-7b-dev-ed.develop.my.salesforce.com"
    When I enter "123" in the username field
    And I enter "22131" in the password field
    And I click on the Login to Salesforce button
    Then I should see the error message "Please check your username and password. If you still can't log in, contact your Salesforce administrator."
