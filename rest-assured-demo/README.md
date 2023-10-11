# Cucumber Tests for Dummy API

This project contains Cucumber tests for the "Dummy API" project, which is a simple Spring Boot API for file operations. The Cucumber tests verify the API's functionality using behavior-driven development (BDD) scenarios.

## Project Structure

- **src/main/java/com/OctaneWolf/cucumberRestAssuredDemo**: Contains the Cucumber step definitions for the test scenarios.
- **src/test/resources/featureFiles**: Contains the feature files with Gherkin scenarios to be executed.

## Features

### Scenario 1: Create a Text File
- Verifies the creation of a text file with the provided details.
- Validates the response status code and response body.

### Scenario 2: Create a Text File with Missing Content
- Tests the creation of a text file without content.
- Validates the response status code and response body.

## Getting Started

1. Clone this repository.
2. Ensure you have the "Dummy API" running on the specified API endpoint.
3. Run the Cucumber tests.

## Prerequisites

- Java 8+
- Maven
- "Dummy API" project (running and accessible)
