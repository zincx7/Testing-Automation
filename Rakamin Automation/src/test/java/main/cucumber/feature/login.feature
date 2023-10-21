Feature: Log in to application

  Scenario: User login with valid credential
    Given User access the website
    When User insert Username with the list provided
    And User insert password with the list provided
    Then User click login button
    Then User on Dashboard Page

    Scenario: Failed Login with invalid credential
      Given User access the website
      And User insert Username with the list provided
      And User insert invalid password with the list provided
      Then User click login button
      Then User get error message

