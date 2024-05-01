// ********RoostGPT********
/*
Test generated by RoostGPT for test new-credential-wallet-rest-assured-integration-test using AI Type Open AI and AI Model gpt-4

ROOST_METHOD_HASH=a991089179
ROOST_METHOD_SIG_HASH=5a667c5d20

 ########## Scenario ##########

{
  background: 'Given the base URL is "http://localhost:8080"',
  rule: null,
  scenario: 'Get Registration Details Of Recipient Person\r\n' +
    '    Given id of recipient as 27364922937 in path parameter\r\n' +
    '    And size=13 and offset=42 in request query\r\n' +
    '    When the client sends a GET request to endpoint "/recipients/persons/{id}/registrations" \r\n' +
    '    When authentication token is sent in request\r\n' +
    '    Then for successful request having status code 200, Verify that headers have api-version, page-size and  page-offset\r\n' +
    '    And response body must have element registrations and total.',
  title: 'Get Registration Details Of Recipient Person'
}

*/

// ********RoostGPT********
package com.mycompany.app.RoostTest;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetRegistrationDetailsOfRecipientPersonTest {

	private List<String[]> payloads = new ArrayList<>();

	@BeforeEach
	public void setUp() throws Exception {
		Path payloadFilePath = FileSystems.getDefault()
			.getPath("src/test/java/com/mycompany/app/RoostTest/GetRegistrationDetailsOfRecipientPersonTest.csv");
		BufferedReader br = new BufferedReader(new FileReader(payloadFilePath.toFile()));

		String line;
		while ((line = br.readLine()) != null) {
			if (!line.trim().isEmpty()) {
				payloads.add(line.split("\\^\\|\\^"));
			}
		}

		br.close();
	}

	@Test
	public void testGetRegistrationDetailsOfRecipientPerson() {
		for (String[] payload : payloads) {
			String method = payload[0];
			String url = payload[1];
			JSONObject headersJson = new JSONObject(payload[2]);
			String reqBody = payload[3];
			int expectedResponseCode = Integer.parseInt(payload[4]);
			JSONObject expectedResponseBody = new JSONObject(payload[5]);

			Headers headers = new Headers(headersJson.toMap());

			Response response = given().headers(headers)
				.body(reqBody)
				.when()
				.request(method, url)
				.then()
				.extract()
				.response();

			// Validate status code
			assertEquals(expectedResponseCode, response.statusCode(), "Status code mismatch");

			// Validate response body
			assertEquals(expectedResponseBody.toMap(), response.getBody().as(JSONObject.class).toMap(),
					"Response body mismatch");
		}
	}

}
