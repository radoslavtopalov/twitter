Feature: Login page

  Scenario: Login with valid credentials
    Given Website is opened
    When Login with Username: "gocigey967@tmailcloud.com" and Password: "Otawa@1"
    Then User is logged in
