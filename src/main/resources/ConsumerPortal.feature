Feature: Consumer Portal

  Scenario Outline: Verify that it is possible to log in Consumer Portal using passKey
    Given Consumer Portal with passkey enabled was accessed
    And the button Sign with your bank was clicked
    And the Demo Bank was selected via lightbox search
    And the username <username> was typed
    And the password <password> was typed
    When the button Agree and Sign In is clicked
    And the account <bankAccount> is selected
    And Continue button is clicked
    Then the CP HomePage should be displayed

  Examples:
    | username     | password   | bankAccount             |
    | "John Smith" | "password" | "Demo Checking Account" |

  Scenario Outline: Verify that it is possible to log in Consumer Portal via Dynamic Widget
    Given Consumer Portal was accessed
    And the <bankName> was selected via widget search
    And the username <username> was typed
    And the password <password> was typed
    When the button Agree and Sign In is clicked
    Then the CP HomePage should be displayed

    Examples:
      | username     | password   | bankAccount             | bankName    |
      | "John Smith" | "password" | "Demo Checking Account" | "Demo Bank" |