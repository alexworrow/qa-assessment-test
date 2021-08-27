@Tests
Feature: Finding the Truth

  Background:
    Given I am on the Finding the Truth screen
    And I select the Start button

  Scenario: Starting Case 2
    When I select the case "Who is to blame?"
    Then I will be taken to the "Who is to blame?" case screen

  Scenario Outline: Selecting Guilty or Not Guilty for the first choice in Case 1
    When I select the case "Making a case against Kevin"
    And I navigate to the 'Guilty or not' screen
    And I vote "<vote>" for my first choice in case one
    Then the "<vote>" notification will be displayed

    Examples:
      | vote        |
      | GUILTY!     |
      | NOT GUILTY! |

  #Potential improvement for the following scenario would be to turn it into a Scenario Outline.
  #That way all the case study links could be tested for the final verdict screen in the one scenario.
  Scenario: Navigating to the DNA case study from the final verdict screen
    When I select the case "Making a case against Kevin"
    And I navigate to the Final Verdict screen
    And I select the DNA case study
    Then I will be taken to the DNA case study screen