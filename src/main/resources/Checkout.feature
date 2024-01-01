Feature: Payment Link

  Scenario: Verify that a payment link is being generated correctly
    Given a payment link was generated
    When the payment link is accessed
    Then it should open the payment information

  Scenario Outline: Verify that a payment using an invalid credit card returns an error message for the consumer
    Given a payment link was generated
    And the payment link was accessed
    And the credit card option was selected
    When the transaction amount is displayed
    And the card number <cardNumber> is filled
    And the card name <cardName> is filled
    And the Due date is filled
    And CVV card is displayed
    And <installments> installments were selected
    And terms Of Use was checked
    And the button to conclude payment was clicked
    Then the system should return <returnMessage>

    Examples:
      | returnMessage                              | installments | cardNumber         | cardName     |
      | "Transação não aprovada. Tente novamente." | "1"          | "5155901222270002" | "John Smith" |

