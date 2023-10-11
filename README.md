# Dummy API and Cucumber Tests

This repository contains two projects:

1. **Dummy API - File Operations:**
    * A simple Spring Boot API for file operations.
    * **Location:** `dummyAPI` folder.

2. **Cucumber / REST-Assured tests for Dummy API:**
    * Cucumber tests to verify the functionality of the Dummy API.
    * **Location:** `rest-assured-demo` folder.

## Dummy API - File Operations

A simple Spring Boot API for file operations. This API allows you to create, delete, read, and list files in a specified directory.

### API Endpoints

- **Create a Text File**
    - **Endpoint:** `/file/create`
    - Creates a text file with the provided content in the specified directory.

- **Delete a Text File**
    - **Endpoint:** `/file/delete`
    - Deletes the specified text file from the specified directory.

- **Read a Text File**
    - **Endpoint:** `/file/read`
    - Reads the content of the specified text file from the specified directory.

- **List Files in a Directory**
    - **Endpoint:** `/file/list`
    - Lists all files in the specified directory.


## Cucumber / REST-Assured tests for Dummy API

This project contains Cucumber tests for the "Dummy API" project, which is a simple Spring Boot API for file operations. The Cucumber tests verify the API's functionality using behavior-driven development (BDD) scenarios.

### Project Structure

- **src/test/java/com/OctaneWolf/cucumberRestAssuredDemo**: Contains the Cucumber step definitions for the test scenarios.
- **src/test/resources**: Contains the feature files with Gherkin scenarios to be executed.

### Test Scenarios

1. **Scenario 1: Create a Text File**
    - Verifies the creation of a text file with the provided details.
    - Validates the response status code and response body.

2. **Scenario 2: Create a Text File with Missing Content**
    - Tests the creation of a text file without content.
    - Validates the response status code and response body.
