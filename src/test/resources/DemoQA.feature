Feature: DemoQA tests

  @regression
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

  @regression
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

  @regression
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

  @regression
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

  @regression
  Scenario Outline: Verify that it is not possible to select a disabled radio button
    Given DemoQA application was accessed
    And Elements menu was clicked
    And the Radio Button item was clicked
    When the <radio> option is clicked
    Then the radio button should not be clickable

  Examples:
    | radio |
    | "No"  |

  @regression
  Scenario: Verify that it is possible to create a new row on the table
    Given DemoQA application was accessed
    And Elements menu was clicked
    And the Web Tables item was clicked
    When the Add button is clicked
    And First Name field is filled with "Sebastian"
    And Last Name field is filled with "Alucard"
    And Email field is filled with "sebastian@examples.com"
    And Age field is filled with "234"
    And Salary field is filled with "100.000"
    And Department field is filled with "Legal"
    And Registration Submit button is clicked
    Then a new row with the added info should be created on the table

  @regression
  Scenario: Verify that a blank field on create new row, triggers an error on screen
    Given DemoQA application was accessed
    And Elements menu was clicked
    And the Web Tables item was clicked
    When the Add button is clicked
    And Registration Submit button is clicked
    Then empty fields should display an error mark

  @regression
  Scenario: Verify that it is possible to search for a term on the table
    Given DemoQA application was accessed
    And Elements menu was clicked
    And the Web Tables item was clicked
    When the search field is clicked
    And the term "Alden" is typed
    Then the correspondent result should be displayed on the Table

  Scenario: Verify that it is possible to edit a line of the table
    Given DemoQA application was accessed
    And Elements menu was clicked
    And the Web Tables item was clicked
    When edit button is clicked on the first table row
    And the Last Name field is changed to Stuart
    And the Registration Submit button is cicked
    Then the first row last name should be displayed as "Stuart"

  Scenario: Verify that it is possible to delete a line of the table
    Given DemoQA application was accessed
    And Elements menu was clicked
    And the Web Tables item was clicked
    When Delete button is clicked on the first table row
    Then the deleted row should not be displayed on the table

  Scenario: Verify that it is possible to change the amount of rows displayed per page
    Given DemoQA application was accessed
    And Elements menu was clicked
    And the Web Tables item was clicked
    When the "5 rows" option on table pagination dropdown is selected
    Then 5 rows should be displayed on the Table

  Scenario: Verify that it is possible to navigate to the second table page
    Given DemoQA application was accessed
    And Elements menu was clicked
    And the Web Tables has more than 5 Rows
    And the "5 rows" option on table pagination dropdown is selected
    And the Previous button is disabled
    When the Next button is clicked
    Then the second page of the Table should be displayed

  Scenario: Verify that Previous and Next button are disabled when there is no pagination on the Table
    Given DemoQA application was accessed
    And Elements menu was clicked
    And the Web Tables has more than 5 Rows
    When there are less than 5 rows on the table
    Then the Next button should be disabled
    And the Previous button should be disabled