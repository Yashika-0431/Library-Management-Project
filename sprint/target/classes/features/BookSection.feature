@BookSection
Feature: View Books in Book Section

  Scenario: Display all books in section
    Given user is on the Book section
    Then list of books should be displayed

  Scenario: Search returns matching books
    Given user is on the Book section
    When user enters "The Complete Stories" as search keyword
    Then relevant books should be displayed
