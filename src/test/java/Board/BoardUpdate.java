package Board;

import org.testng.annotations.Test;

import apiTest.SetVariable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BoardUpdate {
	
	@Test
	public static void Put()
	{
		
		//Base URL
		RestAssured.baseURI="https://api.trello.com";
		
		//Input Data
		String data="{\"name\" : \"API\"}";
		
		// Creating a Request
		RequestSpecification req= RestAssured.given().queryParam("key",SetVariable.getKey())
                			.queryParam("token",SetVariable.getToken());
		
		
		//Defining Parameters
		Response res1 = req.header("Content-Type","application/json")
				 			.body(data)
				 			.when().put("/1/boards/"+SetVariable.getIdBoard());	//Creating put request
	     
		
		// OutPut
		res1.prettyPeek();
	}
	
}
