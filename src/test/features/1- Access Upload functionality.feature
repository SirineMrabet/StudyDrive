Feature: Verify the ability to access the upload page.
  As a registered user I can access a upload functionality



  @stable @positive
  Scenario: Verify that a registered user can access to the upload functionality via the button
    Given I'm a registered user
    When  I log in
    Then I can access to the upload functionality via the button


  @stable @positive
  Scenario: Verify that a registered user can access to the upload functionality via the upload link
    Given I'm a registered user
    When  I log in
    Then I can access to the upload functionality via the upload link
