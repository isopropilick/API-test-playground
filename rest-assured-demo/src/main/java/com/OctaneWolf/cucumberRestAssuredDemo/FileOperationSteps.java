package com.OctaneWolf.cucumberRestAssuredDemo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Map;

public class FileOperationSteps {
    private Response response;

    @Given("the API is up and running on {string}")
    public void theApiIsUp(String url) {
        RestAssured.baseURI = url;
    }

    @When("a user sends a POST request to create a file with the following details:")
    public void POSTCreateFile(DataTable dataTable) {
        List<Map<String, String>> fileDetails = dataTable.asMaps(String.class, String.class);
        if (fileDetails.size() != 1) {
            throw new IllegalArgumentException("Expected one set of file details in the DataTable.");
        }
        Map<String, String> details = fileDetails.get(0);
        this.response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("file-name", details.get("File Name"))
                .header("directory", details.get("Directory"))
                .body(details.get("Content"))
                .when()
                .post("/file/create");
    }

    @Then("the response status code should be {int}")
    public void validateStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals(expectedStatusCode, actualStatusCode, "Response status code does not match the expected status code.");
    }

    @Then("the response body should be {string}")
    public void validateResponseBody(String expectedResponse) {
        String actualResponseBody = response.getBody().asString();
        assertEquals(expectedResponse, actualResponseBody, "Response body does not match the expected body.");
    }

    @When("a user sends a POST request to create a file with missing content with the following details:")
    public void POSTCreateFileWithoutBody(DataTable dataTable) {
        List<Map<String, String>> fileDetails = dataTable.asMaps(String.class, String.class);
        if (fileDetails.size() != 1) {
            throw new IllegalArgumentException("Expected one set of file details in the DataTable.");
        }
        Map<String, String> details = fileDetails.get(0);
        this.response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("file-name", details.get("File Name"))
                .header("directory", details.get("Directory"))
                .when()
                .post("/file/create");
    }

}
