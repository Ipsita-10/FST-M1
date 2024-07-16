package activities;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.AfterClass;



public class Activity1 {
	static String baseUrl;
	int petId;
	@BeforeClass
	  public void beforeClass() {
		baseUrl = "https://petstore.swagger.io/v2/pet" ;
	  }
	
	//GET https://petstore.swagger.io/v2/pet/{petId}
		@Test(priority = 2)
		public void getRequestWithPathParams() {
			given().
				baseUri(baseUrl).
				header("Content-Type", "application/json").
				pathParam("petId", 77232).
			when().
				get("/{petId}").
			then().
				statusCode(200).
				body("status", equalTo("alive")).
				body("name", equalTo("Riley")).
				log().all();
		}
	
	//POST https://petstore.swagger.io/v2/pet
	@Test(priority = 1)
	public void postRequest() {
		String reqBody = "{\n"
				+ "  \"id\": 77232,\n"
				+ "  \"name\": \"Riley\",\n"
				+ "  \"status\": \"alive\"\n"
				+ "}";
		
				given().
					header("Content-Type", "application/json").
					body(reqBody).
				when().
					post(baseUrl).
				then().
					statusCode(200).
					body("id", equalTo(77232)).
					body("name", equalTo("Riley")).
					body("status", equalTo("alive")).
					log().all();
				;
				
	}
	
	//DELETE https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority = 3)
	public void deleteRequest() {
	given().
		header("Content-Type", "application/json").
		pathParam("petId", 77232).
	when().
		delete(baseUrl +"/{petId}").
	then().
		statusCode(200).
		body("message", equalTo(""+petId)).
		log().all();
	}
  

  @AfterClass
  public void afterClass() {
  }

}
