// ********RoostGPT********
/*
Test generated by RoostGPT for test MiniProjects using AI Type Azure Open AI and AI Model roost-gpt4-32k

Test generated for /authorizations_post for http method type POST in rest-assured framework

RoostTestHash=ed8c1b7bff


*/

// ********RoostGPT********
package com.mycompany.app.RoostTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class authorizationsPostTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      envList = dataloader.loadData("src/test/java/com/mycompany/app/RoostTest/authorizationsPostTest.csv");
    }

  
    @Test  
    public void authorizationsPost_Test() {
        this.setUp();
        for (Map<String, String> map : envList) {
          RestAssured.baseURI = map.get("BASE_URL");  
  
                Response response = given()
				.contentType(ContentType.JSON)
				.body("{\n"+
					"  \"email\": \"" + (map.get("email") != null ? map.get("email") : "") + "\n" +
 				"}")
				.header("Token", map.get("API_KEY"))
                .when()
                .post("/authorizations")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 201) {
					System.out.println("Description: successful operation");
      
              if (response.jsonPath().get("id") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("id"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("name") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("name"), matchesPattern("^[\p{L} .'-]{1,100}$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("name"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("email") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("email"), matchesPattern("^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("email"), instanceOf(String.class));MatcherAssert.assertThat(
                  response.jsonPath().getString("email"),
                  Matchers.matchesPattern("^[^\s@]+@[^\s@]+\.[^\s@]+$")
                ); 
  
          }
      
              if (response.jsonPath().get("createdAt") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("createdAt"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("updatedAt") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("updatedAt"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 400) {
					System.out.println("Description: Bad Request");
      
              if (response.jsonPath().get("error") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("error") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("error"), matchesPattern("^validation/.*$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("value") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("value"), instanceOf(undefined.class));  
          }
      
              if (response.jsonPath().get("field") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("field"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("schema_field") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("schema_field"), instanceOf(String.class));  
          }
				}
if (response.statusCode() == 401) {
					System.out.println("Description: Authentication Required");
      
              if (response.jsonPath().get("error") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("error") != null) {    
                MatcherAssert.assertThat(response.jsonPath().getString("error"), matchesPattern("^validation/.*$")); 
  
                MatcherAssert.assertThat(response.jsonPath().get("error"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("description") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("value") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("value"), instanceOf(undefined.class));  
          }
      
              if (response.jsonPath().get("field") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("field"), instanceOf(String.class));  
          }
      
              if (response.jsonPath().get("schema_field") != null) {  
                MatcherAssert.assertThat(response.jsonPath().get("schema_field"), instanceOf(String.class));  
          }
				}
  
            }  
    }
}
