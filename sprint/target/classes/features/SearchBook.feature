@search
Feature: Search Books in the Library

  Scenario: Show error for empty search fields
    Given user is on the search page
    When user leaves all fields empty and clicks search
    Then error messages should appear for all mandatory fields

  Scenario: Search with all data from Excel  
    Given user is on the search page
    When user performs book search for all Excel rows
    
      
  
    

    