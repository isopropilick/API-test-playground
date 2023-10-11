Feature: File Operations API

  Background:
    Given the API is up and running on "http://localhost:8080"

  Scenario: Create a Text File
    When a user sends a POST request to create a file with the following details:
      | Content           | File Name       | Directory       |
      | Sample text.      | testfile.txt    | C:/io/          |
    Then the response status code should be 201
    And the response body should be "File created successfully"

  Scenario: Create a Text File with Missing Content
    When a user sends a POST request to create a file with missing content with the following details:
      | File Name       | Directory       |
      | testfile.txt    | C:/io/          |
    Then the response status code should be 400
    And the response body should be "Request body is missing. Please provide the content for the file."
