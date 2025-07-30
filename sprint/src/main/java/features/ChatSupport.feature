@Chat
Feature: Chat Support Form

  Scenario: Show error for empty mandatory fields
    Given user is on the Chat form
    When user submits the form with empty values
    Then error messages should appear for all required fields in chat form

  Scenario: Invalid phone number entered
    Given user is on the Chat form
    When user enters phone number "12345"
    Then error message for phone should be shown as "Phone number must be 10 digits"
    

  Scenario: Submit valid chat support form
    Given user is on the Chat form
    When user fills all required fields correctly
    Then success "Message Sent Successfully" message should be shown
