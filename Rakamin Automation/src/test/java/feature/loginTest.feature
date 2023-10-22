Feature: Using Application
@Regression @positive
Scenario: User login with valid credential
  Given User access the website
    When User insert Username with the list provided
    And User insert password with the list provided
    Then User click login button
    Then User on Dashboard Page
  @Regression @negative
    Scenario: Failed Login with invalid credential
      Given User access the website
      And User insert Username with the list provided
      And User insert invalid password with the list provided
      Then User click login button
      Then User get error message
  @Regression @positive
  Scenario: User Logout
    Given User access the website
    When User insert Username with the list provided
    And User insert password with the list provided
    And User click login button
    Then User on main Page
    When User click burger menu
    And User click Logout
    Then User on landing page
  @Regression @positive
  Scenario: User Doing Transaction
    Given User access the website
    When User insert Username with the list provided
    And User insert password with the list provided
    Then User click login button
    And User on Dashboard Page to doing transaction
    Then User Add Product to cart
    And User click to cart
    Then User click Checkout Button
    When User insert Firstname
    And User insert Lastname
    And User insert Postalcode
    Then User click Continue Button
    And User directed to Overview Page
    Then User click Continue Finish
    And User directed to Checkout Page


