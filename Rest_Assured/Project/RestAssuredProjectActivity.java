package project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestAssuredProjectActivity {
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	int keyId;
	String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIEaaBIJBvHIE3dDAz42CXfa2vCjgsv2AMJ31RZ+v7Hn2";
	@BeforeClass
	public void setUp() {
		requestSpec = new RequestSpecBuilder().
				setBaseUri("https://api.github.com").
				addHeader("Authorization", "token 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").
				addHeader("Content-Type", "application/json").
				build();
		responseSpec = new ResponseSpecBuilder().
				expectResponseTime(lessThanOrEqualTo(3000L)).
				build();
	}
	
	@Test(priority=1)
	public void postRequest() {
		Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("title", "TestAPIKey");
		reqBody.put("key", sshKey);
		
		//send request, save response
		Response response = 
				given().spec(requestSpec).body(reqBody).when().post("/user/keys");
		
		//extract pet id
		keyId = response.then().extract().path("id");
		
		//Assertions
		response.then().spec(responseSpec).statusCode(201);
	}
	
	@Test(dependsOnMethods = {"postRequest"}, priority=2)
	public void getRequest() {
		Response response =
		given().spec(requestSpec).pathParam("keyId", keyId).log().all().
		when().get("/user/keys/{keyId}");
		
		int statusCode = response.getStatusCode();
		response.then().spec(responseSpec).statusCode(200);
		
		Reporter.log("Response code for get request is: "+statusCode);
		
	}
	
	@Test(dependsOnMethods = {"postRequest"}, priority=3)
	public void deleteRequest() {
		Response response =
		given().spec(requestSpec).pathParam("keyId", keyId).log().all().
		when().delete("/user/keys/{keyId}");
		
		int statusCode = response.getStatusCode();
		response.then().spec(responseSpec).statusCode(204);
		
		Reporter.log("Response code for delete request is: "+statusCode);
	}
}
