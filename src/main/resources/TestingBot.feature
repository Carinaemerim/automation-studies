Feature: TestingBot Application

  Scenario: Verify that when the Testing Bot is accessed, the homepage is displayed.
    Given the 'Testing Bot' application was accessed
    When the page loads
    Then the homepage should be displayed

  Scenario: Verify that clicking on free trial redirects the consumer to the trial form page
    Given the 'Testing Bot' application was accessed
    And the Trial button is displayed
    When the consumer clicks on it
    Then the Trial form page should be displayed
