@Library
Feature: Library Card Form Handling

  Scenario: Submit empty form
    Given user is on the Library Card page
    When user submits the form without entering any data
    Then error messages should appear for all required fields

  Scenario Outline: Show error for invalid email formats
    Given user is on the Library Card page
    When user enters email "<email>" and submits the form
    Then error message "Enter a valid email address" should be shown

    Examples:
      | email         |
      | test.com      |
      
  Scenario: Invalid phone number entered in library card page
    Given user is on the Library Card page
    When user enters phone number "12345" on Library Card page
    Then error message for phone should be shown as "Phone number must be 10 digits" on Library Card page

  Scenario: Selecting Student shows school name field
    Given user is on the Library Card page
    When user selects "Student" as Work Type
    Then School Name field should be displayed

  Scenario: Selecting Employee shows company name field
    Given user is on the Library Card page
    When user selects "Employee" as Work Type
    Then Company Name field should be displayed

  Scenario: Submit form with valid data
    Given user is on the Library Card page
    When user fills all fields with valid data and submits
    Then user record should appear in the library card list
