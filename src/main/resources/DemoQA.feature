Feature: DemoQA tests

  Scenario: Verify that it is possible to send the Text Box Element
    Given DemoQA application was accessed
    And Elements menu was clicked
    And Text Box item was clicked
    And the name <fullName> was typped on the Full name field
    And the email <email> was typped on the Email field
    And the address <currentAddress> was typped on the Current Address field
    And the address <permanentAddress> was typped on the Permanent Address field
    When Submit button is clicked
    Then all informations added should be displayed at the bottom fo the form


