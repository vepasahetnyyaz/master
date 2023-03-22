Feature: Validating different scenarios for insurance

  Scenario: : Verify successful login with valid credentials
    Given user navigates to "ElarLogisticsApp" application
    When users enters username "student1@mindtek.com" and password "mindtekschool"
    And users clicks on the login button
    And user clicks on the add company button


    Scenario: Validating insurance information
