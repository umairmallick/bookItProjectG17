Feature:Login
  Scenario:user should be able to login with valid credentials
  Given User is on the login page
  When User enters email "ecrasford8s@dagondesign.com" and password "bricesiddell"
  Then Home Page should be displayed with "map" heading