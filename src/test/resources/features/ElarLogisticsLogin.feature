Feature: Elar Logistics web application Login Feature


  #Before
  Scenario: Verify successful login with valid credentials
    Given user navigates to "ElarLogisticsApp" application
    When users enters username "student1@mindtek.com" and password "mindtekschool"
    And users clicks on the login button
    Then users validates application is logged in
    #After

  #Before
  Scenario: Verify successful login with invalid credentials
    Given user navigates to "ElarLogisticsApp" application
    When users enters username "student1@mindtek.com" and password "mindtek"
    And users clicks on the login button
    Then users validates an error message "Unable to log in with provided credentials."
    #After

  #Before
  Scenario: Verify Remember Me checkbox functionality
    Given user navigates to "ElarLogisticsApp" application
    When users enters username "student1@mindtek.com" and password "mindtekschool"
    And user check on the rememberMe checkbox
    And users clicks on the login button
    And user clicks on the logout button
    Then users validates the username and theme selection is remembered
    #After