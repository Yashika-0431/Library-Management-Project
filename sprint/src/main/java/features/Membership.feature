@Member
Feature: Membership Form and Member List

  Scenario: Create new membership with valid data
    Given user is on the Membership form
    When user clicks on type of membership "Gold Membership" and enters card number "2300A21"
    Then message "Membership Added" should be shown

  Scenario: View all members in list
    Given user is on the Member List page
    Then list of all members should be shown
