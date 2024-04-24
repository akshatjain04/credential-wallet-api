// ********RoostGPT********
/*
Test generated by RoostGPT for test rest-assured-integration-insights-UI-test using AI Type Open AI and AI Model gpt-4

ROOST_METHOD_HASH=dff35151d7
ROOST_METHOD_SIG_HASH=3a7061432c

 ########## Scenario ########## 

{
  background: 'Given the base URL is "http://localhost:8080"',
  rule: null,
  scenario: 'Create my account \r\n' +
    '    When the client sends a POST request "/accounts" with the accounts_body payload\r\n' +
    '    Then create an account with the specified informatio\r\n' +
    '    And verify the account created using GET request for "/me"',
  title: 'Create my account'
}

*/

// ********RoostGPT********
package com.mycompany.app.RoostTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateMyAccountTest {
    private BufferedReader reader;
    private String file = "src/test/java/com/mycompany/app/RoostTest/CreateMyAccount.csv";

    @BeforeEach
    public void setup() throws IOException {
        reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine(); // Skip the header
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testCreateMyAccount() throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                continue;
            }
            String[] data = line.split("\\^\\|\\^");
            String method = data[0];
            String url = data[1];
            Map<String, String> headers = new JSONObject(data[2]).toMap();
            String body = data[3];
            int expectedResponseCode = Integer.parseInt(data[4]);
            JSONObject expectedResponseBody = new JSONObject(data[5]);

            RequestSpecification request = given();
            headers.forEach(request::header);
            if (!body.isEmpty()) {
                request.body(body);
            }

            Response response;
            if (method.equalsIgnoreCase("post")) {
                response = request.post(url);
            } else if (method.equalsIgnoreCase("get")) {
                response = request.get(url);
            } else {
                throw new IllegalArgumentException("Invalid method: " + method);
            }

            // Assert the response code
            assertEquals(expectedResponseCode, response.getStatusCode());

            // Assert the response body
            JSONObject responseBody = new JSONObject(response.getBody().asString());
            for (String key : JSONObject.getNames(expectedResponseBody)) {
                assertEquals(expectedResponseBody.get(key), responseBody.get(key));
            }
        }
    }
}
