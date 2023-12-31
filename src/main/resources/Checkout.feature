Feature: Payment Link

  Scenario: Verify that a payment link is being generated correctly
    Given the merchant generated a payment link
    When the consumer accesses the payment link
    Then it should open the payment information

  Scenario Outline: Verify that a payment using an invalid credit card returns an error message for the consumer
    Given the merchant generated a payment link
    And the consumer accessed the payment link
    And the credit card option was selected
    When he adds a credit card information
    And <installments> installments were selected
    And termsOfUse was checked
    Then the system should return <message>

    Examples:
      | message                | installments |
      | "Invalid card message" | "1"          |

