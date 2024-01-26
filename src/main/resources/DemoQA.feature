Feature: DemoQA tests

  Scenario Outline: Verify that it is possible to send data on the TextBox Element
    Given DemoQA application was accessed
    And Elements menu was clicked
    And Text Box item was clicked
    And the name <fullName> was typed on the Full name field
    And the email <email> was typed on the Email field
    And the address <currentAddress> was typed on the Current Address field
    And the address <permanentAddress> was typed on the Permanent Address field
    When Submit button is clicked
    Then all information added should be displayed at the bottom fo the form

  Examples:
    | fullName          | email                        | currentAddress                        | permanentAddress                      |
    | "Joana Guimarães" | "joanaguimaraes@example.com" | "Rua Porto Alegre, 300, Araranguá SC" | "Rua Porto Alegre, 300, Araranguá SC" |

  Scenario Outline: Verify that it is possible to interact on checkbox Element
    Given DemoQA application was accessed
    And Elements menu was clicked
    And the Check Box item was clicked
    And the Home arrow was clicked
    And the Desktop arrow was clicked
    When the Check Box Notes item is checked
    And a confirmation message <message> is displayed
    And the Check Box item is unchecked
    Then the confirmation message should not be displayed anymore

  Examples:
    | message |
    | "notes" |

  Scenario Outline: Verify that it is possible to interact on two checkbox Elements
    Given DemoQA application was accessed
    And Elements menu was clicked
    And the Check Box item was clicked
    And the Home arrow was clicked
    And the Desktop arrow was clicked
    When the Check Box Notes item is checked
    And the Check Box Commands is checked
    Then a confirmation <message> message should be displayed
    And a confirmation <message> message should be displayed

  Examples:
    | message    | message    |
    | "commands" | "notes"    |

  Scenario Outline: Verify that it is possible to select the radio button
    Given DemoQA application was accessed
    And Elements menu was clicked
    And the Radio Button item was clicked
    When the <radio> option is clicked
    Then a radio selection confirmation <message> message should be displayed

  Examples:
    | radio        | message      |
    | "Yes"        | "Yes"        |
    | "Impressive" | "Impressive" |

  Scenario Outline: Verify that it is not possible to select a disabled radio button
    Given DemoQA application was accessed
    And Elements menu was clicked
    And the Radio Button item was clicked
    When the <radio> option is clicked
    Then the radio button should not be clickable

  Examples:
    | radio |
    | "No"  |