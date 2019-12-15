Feature: Login page

  Scenario: Login with valid credentials
    Given Website is opened
    When Login with Username: "gocigey967@tmailcloud.com" and Password: "Otawa@1"
    And Post new Tweet with text "New Tweet!"
    And Delete tweet
   # Then Tweet is deleted
    Then Verify Tweet is deleted with "Your Tweet was deleted" alert message


