@Email
Feature: Email Support Form

  Scenario: Show error for empty mandatory fields
    Given user is on the Email Support form
    When user submits the form with empty mandatory fields
    Then error messages should be shown for required fields

  Scenario: Invalid email format in 'From' field
    Given user is on the Email Support form
    When user enters "invalid.com" as From email and submits
    Then error message "Enter a valid email" should be shown
    
  Scenario: Submit valid email support form
    Given user is on the Email Support form
    When user enters valid data and submits the form
    Then success message "Mail Sent Successfully" should be shown
