Feature: Verify the ability to upload a file
  As a registered user I can upload files


  @stable @positive
  Scenario Outline: Verify that a registered user can upload one file
    Given I'm a registered user
    When  I log in
    Then I can access to the upload functionality via the button
    And I can upload one file with <FileName>
    And Name is set to <FileName>
    And we can set <Description>, <Professor>, <DocType> and <Semester>
    And set the <UploadType>
    And open file with <FileName> and <Semester> in the corresponding course
    Examples:
      | FileName | Description | Professor | DocType | Semester    | UploadType  |
      | 213.pdf  | TBD         | DR.Oliver | Exams   | Summer 2012 | anonymously |
