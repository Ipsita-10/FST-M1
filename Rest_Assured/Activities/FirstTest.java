package examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {

	//GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
	@Test
	public void getRequestWithQueryParam() {
		Response resonse=
				(Response) given().baseUri("https://petstore.swagger.io/v2/pet").
		header("Content-Type","application/json").queryParam("status", "alive").
		when().
		get("/findByStatus");
		
		
		System.out.println(resonse.getHeaders());
		
		System.err.println(resonse.getBody().asString());
		
		System.out.println(resonse.getBody().asPrettyString());
		
		// extract properties from response
		
		String petStatus=resonse.then().extract().path("[0].status"); // pathQuery >> $[0].status >> response has 2 data , i want first pet status hence used [0]
		
		Assert.assertEquals(petStatus, "alive");
		
		//restAssured assertion
		
		resonse.then().statusCode(200).body("[0].status", equalTo("alive"));
		
	}
	
	@Test
	public void getRequestWithPathParam() {
		// send request, get response, and assert with logging
		given().baseUri("https://petstore.swagger.io/v2/pet").
		header("Content-Type","application/json").
		pathParam("petId", 77232).
		when().
		    get("/{petId}").
		then().
		statusCode(200).body("status", equalTo("alive"));
		
		
		
		// Path parameter is used to create request dynamically, meaning here path parameter that we are passing will be replaced in get() danyamically with its id 77232 and then will hit the get request
		
		
	}
}
